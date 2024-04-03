package views;

import users.LoggedUser;

public class HeaderView {
    LoggedUser user = null;

    public HeaderView(LoggedUser user){
        this.user = user;
    }


    @Override
    public String toString() {
        return 
        "<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">"+
        "    <a class=\"navbar-brand\" href=\"#\">Usuarios</a>"+
        "    <div class=\"collapse navbar-collapse justify-content-end\">"+
        "        <ul class=\"navbar-nav\">"+
        "            <li class=\"nav-item\">"+
        "                <a class=\"nav-link\" href=\"#\">"+user.getUsername()+"</a>"+
        "            </li>"+
        "       </ul>"+
        "    </div>"+
        "</nav>";
    }
    
}
