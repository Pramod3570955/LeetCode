class Twitter {

    Map<Integer, User> users = new HashMap<>();

    int timestamp = 0;

    class User {
        int id;
        Set<Integer> following = new HashSet<>();
        List<Tweet> tweets = new ArrayList<>();

        User(int id) {
            this.id = id;

            // User follows themselves
            following.add(id);
        }
    }

    class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        users = new HashMap<>();
    }

    private User getUser(int userId) {

        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }

        return users.get(userId);
    }

    public void postTweet(int userId, int tweetId) {

        User user = getUser(userId);

        timestamp++;

        user.tweets.add(new Tweet(tweetId, timestamp));
    }

    public List<Integer> getNewsFeed(int userId) {

        User user = getUser(userId);

        PriorityQueue<Tweet> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(b.time, a.time)
            );

        for (int followeeId : user.following) {

            User followee = users.get(followeeId);

            pq.addAll(followee.tweets);
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < 10) {
            result.add(pq.poll().id);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        User follower = getUser(followerId);
        getUser(followeeId);

        follower.following.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        User follower = getUser(followerId);

        if (followerId != followeeId) {
            follower.following.remove(followeeId);
        }
    }
}