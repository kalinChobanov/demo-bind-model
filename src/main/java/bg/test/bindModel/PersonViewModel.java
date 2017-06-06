/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.test.bindModel;

/**
 *
 * @author Kalin
 */
public class PersonViewModel {

    private String name;

    private AddressViewModel address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressViewModel getAddress() {
        return address;
    }

    public void setAddress(AddressViewModel address) {
        this.address = address;
    }

}
