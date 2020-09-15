package ru.pekchiorckin.rest.user;

import javax.persistence.*;

@Entity
@Table
public class User{
    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer phone;
    User(String name, Integer phone){
        this.name = name;
        this.phone = phone;
    }

    public User(){}

    public User(Integer id, String name, Integer phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}
