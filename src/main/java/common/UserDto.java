package common;

public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String username;


    public UserDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
