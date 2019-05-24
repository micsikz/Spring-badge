package hu.flowacademy.badge.domain;

import javax.persistence.*;

@Entity
@Table(name = "badge")
public class Badge {

    @Id
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name = "content")
    private byte[] content;

    @Column(name = "owner")
    private String owner;

    @ManyToOne
    @JoinColumn(name = "user_name", foreignKey = @ForeignKey(name = "fk_user_badge"))
    private User user;

    public Badge() {
    }

    public Badge(long id, String name, byte[] content, String owner) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
