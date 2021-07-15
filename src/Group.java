import java.util.*;

public class Group {
    private int id;
    private String title;
    private int parentId;
    private List<Item> items;
    private List<Group> groups;

    public static  List<Group> groupList = new ArrayList<>();
    public Group(int id, String title ) {
        this.id = id;
        this.title = title;
        this.items = new ArrayList<>();
        this.groups = new ArrayList<>();
        parentId = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroups( Group group) {

        this.groups.add(group);
    }

    public int getParent() {
        return parentId;
    }

    public void setParent(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", title='" + title + "}";
    }
    public static void printContent() {
for(Group group: groupList) {
    System.out.println("Id: "+group.id+", title :"+group.title+", ParentId: "+group.parentId+", Subgroups: "+group.groups+", Intems: "+group.items);
}

    }
}
