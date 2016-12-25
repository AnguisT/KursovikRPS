package Models;

public class Role {
    
    private Long NumberPassport;
    private String Role;
    
    private People people;

    public Long getNumberPassport() {
        return NumberPassport;
    }

    public void setNumberPassport(Long NumberPassport) {
        this.NumberPassport = NumberPassport;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
