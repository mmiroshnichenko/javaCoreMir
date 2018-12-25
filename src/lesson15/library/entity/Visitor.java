package lesson15.library.entity;

public class Visitor {
    private long id;
    private String name;
    private String contact;

    public Visitor(long id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visitor visitor = (Visitor) o;

        if (id != visitor.id) return false;
        if (!name.equals(visitor.name)) return false;
        return contact.equals(visitor.contact);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + contact.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
