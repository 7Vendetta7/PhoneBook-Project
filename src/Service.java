/**
 * Description: This file contains class Service which is created for implementing
 *              all the necessary methods for my version of this project.
 *              Methods - showContactList, addContact, removeContact, editContact, searchContact, getContact
 *
 *              * Below you can find all the methods with their implementations.
 *
 * @author Argishti_Tigranyan
 */

import java.util.*;

public class Service
{
    Contact contact = new Contact();
    TreeMap<String, ArrayList<Contact>> myContactList = new TreeMap<String, ArrayList<Contact>>();

    /**
     * Method Description: This method prints all the contacts which the user have created. User should mention
     *                     coressponding name of phonebook which is represented in my version of project as treeMap.
     *
     *
     * @method_name showContactList
     */

    void showContactList(TreeMap<String, ArrayList<Contact>> treeMap)
    {
        Collection res = treeMap.values();
        Iterator i = res.iterator();

        while (i.hasNext())
        {
            System.out.println(i.next());
        }
    }

    /**
     * Method Description: This method collects all the necessary information from user, calls class
     *                     Contact's constructor and passes the collected fields into it. After, created
     *                     object becomes value of treeMap, and passed first name of contact is setting as key of treeMap.
     *                     (treeMap pairs: first name|Contact type object)
     *
     *
     * @method_name addContact
     */

    public void addContact(TreeMap<String, ArrayList<Contact>> treeMap)
    {

        Scanner input_1 = new Scanner(System.in);
        System.out.println("Enter the first name of your new contact: ");
        String firstNameInput = input_1.nextLine();

        Scanner input_2 = new Scanner(System.in);
        System.out.println("Enter the last name of your new contact: ");
        String lastNameInput = input_2.nextLine();

        Scanner input_3 = new Scanner(System.in);
        System.out.println("Enter the number of your new contact: ");
        String numberInput = input_3.nextLine();

        Scanner input_4 = new Scanner(System.in);
        System.out.println("Enter the phone type of your new contact (*it can be either home, main, work or mobile*): ");
        String EnumInput = input_4.nextLine();

        Contact.PhoneType phoneType1 = null;

        switch (EnumInput.toUpperCase())
        {
            case "MOBILE":
                phoneType1 = Contact.PhoneType.MOBILE;
                break;
            case "HOME":
                phoneType1 = Contact.PhoneType.HOME;
                break;
            case "MAIN":
                phoneType1 = Contact.PhoneType.MAIN;
                break;
            case "WORK":
                phoneType1 = Contact.PhoneType.WORK;
                break;
            default:
                break;
        }

        Contact contact = new Contact(firstNameInput, lastNameInput, numberInput, phoneType1);
        if (treeMap.get(firstNameInput) == null)
        {
            treeMap.put(firstNameInput, new ArrayList<Contact>());
        }
        ArrayList<Contact> contacts = treeMap.get(firstNameInput);
        contacts.add(contact);
    }

    /**
     * Method Description: This method gets from the user first name of the contact which
     *                     user wants to delete and removes from contact list coressponding contact.
     *
     *
     * @method_name removeContact
     */

    public void removeContact(TreeMap<String, ArrayList<Contact>> treeMap)
    {
        Scanner input_1 = new Scanner(System.in);
        System.out.println("Enter the first name of your contact which you want to remove: ");
        String firstNameInput = input_1.nextLine();

        if (treeMap.containsKey(firstNameInput))
        {
            treeMap.remove(firstNameInput);
        }
        else
        {
            System.out.println("Sorry there is no such contact with mentioned first name.");
        }
    }

    /**
     * Method Description: At first this method checks which contact user wants to edit and
     *                     only after it checks which concrete field the user wants to edit.
     *
     *
     * @method_name editContact
     */

    public void editContact(TreeMap<String, ArrayList<Contact>> treeMap)
    {

        Scanner input_1 = new Scanner(System.in);
        System.out.println("Enter the first name of contact which you want to edit: ");
        String firstName = input_1.nextLine();

        Scanner input_2 = new Scanner(System.in);
        System.out.println("Enter field which you want to edit (first name, last name, number): ");
        String edit = input_2.nextLine();

        Scanner input_3 = new Scanner(System.in);
        System.out.println("Enter new field: ");
        String e = input_3.nextLine();

        switch(edit)
        {
            case "first name":
            case  "firstname":
                ArrayList<Contact> contacts = treeMap.get(firstName);
                for(Contact contact: contacts)
                {
                    contact.setFirstName(e);
                }
                break;
            case "last name":
            case "lastname":
                contacts = treeMap.get(firstName);
                for(Contact contact: contacts)
                {
                    contact.setLastName(e);
                }
                break;
            case "number":
                contacts = treeMap.get(firstName);
                for(Contact contact: contacts)
                {
                    contact.setNumber(e);
                }
                break;
            default:
                break;
        }
    }

    /**
     * Method Description: This methods check is there such contact by its coressponding first name,
     *                     which is inputted by the user.
     *
     *
     * @method_name searchContact
     */

        public boolean searchContact(TreeMap<String, ArrayList<Contact>> treeMap)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the first name of the contact which you want to search: ");
            String key = input.nextLine();

            if(treeMap.containsKey(key))
            {
                System.out.println("Contact which you searched exists.");
                return true;
            }
            else
            {
                System.out.println("There is no such contact.");
                return false;
            }
        }

    /**
     * Method Description: This method delivers whole contact information which the user wants.
     *                     User just should mention first name of the contact.
     *                     (there are not any other comments (: )
     *
     * @method_name getContact
     */

        public void getContact(TreeMap<String, ArrayList<Contact>> treeMap)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the first name of the contact which you want to get: ");
            String key = input.nextLine();

            if (treeMap.containsKey(key))
            {
                System.out.println(treeMap.get(key));
            }
            else
            {
                System.out.println("There is no such contact.");
            }
        }

    /**
     * Method Description: General method for combining all the methods and for running project.
     *
     * @method_name displayMenu
     */

    public void displayMenu()
    {

        System.out.println("\t\t\tDear user, Welcome to Phonebook menu.");

        int answer;
        do
            {
            System.out.println("Press coressponding number for the command which you want to use: ");
            System.out.println("1. Add contact");
            System.out.println("2. Remove contact");
            System.out.println("3. Edit contact");
            System.out.println("4. Search contact");
            System.out.println("5. Get contact");
            System.out.println("6. Show contact list");
            System.out.println("7. quit");
            Scanner input = new Scanner(System.in);
            answer = input.nextInt();

            while(answer > 7 && answer < 1)
            {
                System.out.println("Please make a choice between 1 to 6");
                answer = input.nextInt();
            }

            switch (answer) {
                case 1:
                    addContact(myContactList);
                    System.out.println("\nYour mentioned contact was successfully added.\n\nNow you can continue entering new number: ");
                    break;
                case 2:
                    removeContact(myContactList);
                    System.out.println("\nYour mentioned contact was successfully removed.\n\nNow you can continue entering new number: ");
                    break;
                case 3:
                    editContact(myContactList);
                    System.out.println("\nYour mentioned contact was successfully edited.\n\nNow you can continue entering new number: ");
                    break;
                case 4:
                    searchContact(myContactList);
                    System.out.println("Now you can continue entering new number: ");
                    break;
                case 5:
                    getContact(myContactList);
                    System.out.println("Now you can continue entering new number: ");
                    break;
                case 6:
                    showContactList(myContactList);
                    System.out.println("Now you can continue entering new number: ");
                    break;
                            }
            } while (answer != 7);
    }

}