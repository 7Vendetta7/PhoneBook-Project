/**
 * description: Create a phonebook project. Save contacts in a list (List, Set…).
 *              Provide several functions for a user (add, edit, delete, get, search…).
 *              Main – main class that tests all functions defined in the service.
 *              Model – contains models of the project (Contact(firstName, lastName, number…), enums…).
 *              Service – contains CRUD methods (create, edit, update, delete…).
 *
 * @author Argishti_Tigranyan
 */

public class PhoneBook
{
    public static void main(String[] args) {

        Service phoneBook = new Service();

        phoneBook.displayMenu();

    }
}
