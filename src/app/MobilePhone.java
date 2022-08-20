package app;

import java.util.ArrayList;

class MobilePhone{
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }
    public boolean addNewContact(Contact newContact){
        if(findContact(newContact) >= 0){
            System.out.println("Contact already exist");
            return false;
        }
        for(int i = 0; i < myContacts.size(); i++){
            if(myContacts.get(i).getName() ==  newContact.getName()){
                System.out.println("Contact already exist");
                return false;
            }
        }

        myContacts.add(newContact);
        System.out.println("Contact added");
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        if(findContact(newContact) >= 0){
            System.out.println("Contact already exist");
            return false;
        }
        System.out.println("Contact updated");
        int placementOldContact = myContacts.indexOf(oldContact);
        myContacts.set(placementOldContact, newContact);
        return true;
    }

    public boolean removeContact(Contact oldContact){
        if(findContact(oldContact) >= 0 ){
            System.out.println("Contact removed");
            myContacts.remove(oldContact);
            return true;
        }
        System.out.println("Can not find an existing contact");
        return false;
    }

    private int findContact(Contact theContact){
        if(myContacts.contains(theContact)){
            return myContacts.indexOf(theContact);
        }
        return -1;
    }
    private int findContact(String contactName){

        for(int i = 0; i < myContacts.size(); i++){
            if(contactName.equals(myContacts.get(i).getName())) {
                return myContacts.indexOf(myContacts.get(i));
            }
        }
        return -1;
    }
    public Contact queryContact(String name){
        int foundedContact = findContact(name);
        if(findContact(name) >= 0){
            return myContacts.get(foundedContact);
        }
        return null;
    }
    public void printContacts(){
        System.out.println("Contact List:");
        for(int i = 0; i < myContacts.size(); i++){
            System.out.print((i+1)+ ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
            System.out.println();
        }
    }

}