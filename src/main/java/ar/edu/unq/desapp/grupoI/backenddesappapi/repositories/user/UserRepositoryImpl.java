package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.user;

/*
public class UserRepositoryImpl {

    List<UserAbs> userAbs;

    public UserRepositoryImpl() {
        this.userAbs = new ArrayList<>();
    }

    @Override
    public List<UserAbs> getUsers() {
        return this.userAbs;
    }

    @Override
    public UserAbs getUser(long id) {
        Optional<UserAbs> user = userAbs.stream()
                .filter(u -> u.getUserId() == id)
                .findFirst();
        return  user.orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void addUser(UserAbs userAbs) {
        boolean isAdded = this.userAbs.stream().anyMatch(u -> u.getUserId() == userAbs.getUserId());
        if (isAdded) throw new UserHasBeenAddedException();
        this.userAbs.add(userAbs);
    }
}
*/