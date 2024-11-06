package petclinic.model;

public class Pet {
    private int petId;
    private String name;
    private int ownerId;
    private int breedId;

    public Pet(int id, String name, int ownerId, int breedId) {
        this.petId = id;
        this.name = name;
        this.ownerId = ownerId;
        this.breedId = breedId;
    }

    public int getPetId() {
        return petId;
    }
    public String getName() {
        return name;
    }
    public int getOwnerId() {
        return ownerId;
    }
    public int getBreedId() {
        return breedId;
    }
}
