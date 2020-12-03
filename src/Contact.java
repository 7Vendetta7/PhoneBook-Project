import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Description: This file contains class Contact which is created for implementing
 *              all the necessary fields which our future contact should have.
 *              All in all it has fields firstName_, lastName_, number_ (all type of String)
 *              and PhoneType (type of enum). There are setter getters for coressponding fields,
 *              default and non-default constructors and overriden method ToString from Object class.
 *
 * @author Argishti_Tigranyan
 */

public class Contact
{
    private String firstName_;
    private String lastName_;
    private String number_;
    private PhoneType phoneType_;
    public enum PhoneType
    {
        MOBILE,
        HOME,
        WORK,
        MAIN
    }

    void setFirstName(String firstName)
    {
        firstName_ = firstName;
    }

    String getFirstName()
    {
        return firstName_;
    }

    void setLastName(String lastName)
    {
        lastName_ = lastName;
    }

    String getLastName()
    {
        return lastName_;
    }
    void setNumber(String number)
    {
        number_ = number;
    }

    String getNumber()
    {
        return number_;
    }

    Contact()
    {
        firstName_ = "";
        lastName_ = "";
        number_ = "";

    }

    Contact(String firstName, String lastName, String number, PhoneType phoneType)
    {
        firstName_ = firstName;
        lastName_ = lastName;
        number_ = number;
        this.phoneType_ = phoneType;
    }

    @Override
    public String toString() {
        return "|First Name: "+firstName_+"| "+"|Last Name: "+ lastName_+"| "+"|Number: "+number_+"| "+"|Phone Type: "+phoneType_+"|"+"";
    }
}
