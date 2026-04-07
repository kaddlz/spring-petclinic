package org.springframework.samples.petclinic.owner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "owners_contact")
public class OwnerContact {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
	@Id
    private Owner owner;

    @Size(max = 255)
    @Column(name = "address")
	@NotBlank
    private String address;

    @Size(max = 30)
    @Column(name = "city", length = 30)
	@NotBlank
    private String city;

    @Size(max = 20)
    @Column(name = "telephone", length = 20)
	@Pattern(regexp = "^(\\+7|8)\\d{10}$")
	@NotBlank
    private String telephone;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
