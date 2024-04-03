package views;

import users.LoggedUser;

public class MainView {
    LoggedUser user = null;

    public MainView(LoggedUser user){
        this.user = user;
    }


    @Override
    public String toString() {
        return 
        "<div class=\"col\">"+
        "</div>";
    }
    
}
