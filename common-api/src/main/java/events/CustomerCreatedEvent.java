package events;

import lombok.Getter;

public class CustomerCreatedEvent extends BaseEvent<String>{
    @Getter
    private String name;
    @Getter private String address;
    @Getter private String email;
    @Getter private String tel;

    public CustomerCreatedEvent(String id, String name, String address, String email, String tel) {
        super(id);
        this.name = name;
        this.address = address;
        this.email = email;
        this.tel = tel;
    }
}
