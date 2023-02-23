package kz.attractor.java.lesson44;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsersDataModel {
    private UserData users;

    private List<UserData> userDataList = new ArrayList<>();


    public UsersDataModel() {
     this.userDataList= FileService.readUsers();
     this.users = new UserData("ivan@mail.ru","Ivan","qweqwe123");
//        userDataList.add(new UserData("test","test","test"));


    }

    public UserData getUsers() {
        return users;
    }

    public void setUsers(UserData users) {
        this.users = users;
    }

    public List<UserData> getUserDataList() {
        return userDataList;
    }

    public void setUserDataList(List<UserData> userDataList) {

        this.userDataList = userDataList;


    }
}
