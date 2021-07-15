import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Item> availableItems = new ArrayList<>();
        Item item1 = new Item(1, "First Item", 5, "USD");
        Item item2 = new Item(2, "Second Item", 8, "USD");
        Item item3 = new Item(3, "Third Item", 10, "USD");
        Item item4 = new Item(4, "Fourth Item", 15, "USD");
        availableItems.add(item1);
        availableItems.add(item2);
        availableItems.add(item3);
        availableItems.add(item4);

        List<Group> availableGroups = new ArrayList<>();
        Group group1 = new Group(1, "First Group");
        Group group2 = new Group(2, "Second Group");
        Group group3 = new Group(3, "Third Group");
        Group group4 = new Group(4, "Fourth Group");
        availableGroups.add(group1);
        availableGroups.add(group2);
        availableGroups.add(group3);
        availableGroups.add(group4);


        Group choosed = null;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Here available groups: " + availableGroups);
            System.out.println("Please enter the ID of the group you want to choose");
            String command = bf.readLine();
            if (command.equals("exit")) {
                if (choosed != null) choosed.printContent();
                else System.out.println("You have not choosed a group: Program is closing now...");
                break;
            } else {
                try {
                    int id = Integer.parseInt(command);
                    choosed = availableGroups.get(id - 1);

                    System.out.println("Please Enter the id of parent group or type Enter to choose items");
                    command = bf.readLine();
                    while (!command.equals("Enter")) {

                        int parentId = Integer.parseInt(command);
                        Group parentGroup = availableGroups.get(parentId - 1);
                        parentGroup.addGroups(choosed);
                        choosed.setParent(parentGroup);
                        choosed = parentGroup;
                        command = bf.readLine();
                        if (command.equals("continue")) {
                            System.out.println("Here the available items to choose: " + availableItems);
                            System.out.println("please enter the id of item");
                            String itemAddCommant = bf.readLine();
                            while (!itemAddCommant.equals("exit")) {
                                int itemId = Integer.parseInt(itemAddCommant);
                                Item choosedItem = availableItems.get(itemId - 1);
                                choosed.addItem(choosedItem);
                                System.out.println("Item added to group");
                                itemAddCommant = bf.readLine();
                            }
                            parentGroup.printContent();
                            break;

                        }
                        // break;
                    }

                } catch (Exception e) {
                    System.out.println("Wrong Command");

                }

            }


        }
    }
}
