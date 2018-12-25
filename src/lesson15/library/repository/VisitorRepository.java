package lesson15.library.repository;

import lesson15.library.entity.Visitor;

public class VisitorRepository {
    private Visitor[] visitors;

    public VisitorRepository(Visitor[] visitors) {
        this.visitors = visitors;
    }

    public Visitor[] getVisitors() {
        return visitors;
    }

    public Visitor getVisitorById(long id) {
        for (Visitor visitor : visitors) {
            if (visitor != null && visitor.getId() == id) {
                return visitor;
            }
        }

        return null;
    }
}
