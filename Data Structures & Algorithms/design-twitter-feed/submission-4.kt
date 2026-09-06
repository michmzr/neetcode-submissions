class Twitter {
    data class Tweet(val userId: Int, val id: Int, val order: Long)

    val followers = mutableMapOf<Int, MutableSet<Int>>()

    //key - user id, value - list of tweets
    val feeds = mutableMapOf<Int, MutableList<Tweet>>()

    val ownPosts = mutableMapOf<Int, MutableList<Tweet>>()

    var tweets = 0L

    fun postTweet(userId: Int, tweetId: Int) {
        tweets++

        val tweet = Tweet(userId, tweetId, tweets)

        followers
            .getOrDefault(userId, mutableSetOf())
            .forEach { followerId ->
                feeds
                    .getOrPut(followerId) { mutableListOf() }
                    .add(tweet)
            }

        feeds.getOrPut(userId) { mutableListOf() }.add(tweet)

        ownPosts.getOrPut(userId) { mutableListOf() }.add(tweet)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        return feeds[userId]
            .orEmpty()
            .sortedByDescending { it.order }
            .take(10)
            .map { it.id }
    }

    /**
     *  The user with ID followerId follows the user with ID followeeId.
     */
    fun follow(followerId: Int, followeeId: Int) {
        require(followerId != followeeId) {
            "A user cannot follow themself"
        }

        val wasAdded = followers
            .getOrPut(followeeId) { mutableSetOf() }
            .add(followerId)

        // Repeated follow calls must be idempotent.
        if (!wasAdded) {
            return
        }

        val followerFeed = feeds.getOrPut(followerId) { mutableListOf() }
        followerFeed.addAll(ownPosts[followeeId].orEmpty())

        feeds[followerId] = followerFeed
            .sortedByDescending { it.order }
            .toMutableList()
    }

    /**
     * The user with ID followerId unfollows the user with ID followeeId.
     */
    fun unfollow(followerId: Int, followeeId: Int) {
        followers[followeeId]?.remove(followerId)

        if (feeds.containsKey(followerId)) {
            feeds[followerId] = feeds[followerId]
                .orEmpty()
                .filterNot { it.userId == followeeId }
                .sortedByDescending { it.order }
                .take(10)
                .toMutableList()
        }
    }
}