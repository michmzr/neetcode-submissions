class Twitter {

      data class Tweet(val userId: Int, val id: Int, val order: Long = 0)

    val followers = mutableMapOf<Int, MutableSet<Int>>()

    //key - user id, value - list of tweets
    val feeds = mutableMapOf<Int, MutableList<Tweet>>()

    val ownPosts = mutableMapOf<Int, MutableList<Tweet>>()

    var tweets = 0L

    fun postTweet(userId: Int, tweetId: Int) {
        tweets++

        followers
            .getOrDefault(userId, mutableSetOf())
            .forEach {followeeId ->
                 feeds
                    .getOrPut(followeeId) { mutableListOf() }.add(Tweet(userId,tweetId, tweets))
            }

        feeds.getOrPut(userId) { mutableListOf() }.add(Tweet(userId,tweetId))

        ownPosts.getOrPut(userId) { mutableListOf() }.add(Tweet(userId,tweetId, tweets))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        return if (feeds.containsKey(userId)) {
            val feed = feeds[userId]!!
            feed.takeLast(10).map { it.id }
        } else {
            emptyList()
        }
    }

    /**
     *  The user with ID followerId follows the user with ID followeeId.
     */
    fun follow(followerId: Int, followeeId: Int) {
        require(followerId != followeeId,  {"A user cannot follow themself"})

        followers.getOrPut(followeeId) { mutableSetOf() }.add(followerId)

        val followerFeed: MutableList<Tweet> = feeds
            .getOrPut(followerId) { mutableListOf() }

        followerFeed.addAll(ownPosts[followeeId] ?: emptyList())
        followerFeed.sortByDescending { it.order }
        feeds[followerId] = followerFeed.takeLast(10).toMutableList()
    }

    /**
     * The user with ID followerId unfollows the user with ID followeeId.
     */
    fun unfollow(followerId: Int, followeeId: Int) {
        followers[followeeId]?.remove(followerId)

        if (feeds.containsKey(followerId)) {
            val followerFeed: List<Tweet> = feeds.getOrPut(followerId) { mutableListOf() }

            feeds[followerId] = followerFeed
                .takeLast(10)
                .filterNot { it.userId == followeeId }
                .toMutableList()
        }
    }
}
