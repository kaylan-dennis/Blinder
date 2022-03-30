package za.co.wethinkcode.Data;

public class CredentialDO {
    public int id;
    public String hash;
    public int profile_id;
    
    public CredentialDO() {}
    
    public int getId() {
        return this.id;
    }
    
    public int getProfile_id() {
        return this.profile_id;
    }
    
    public String getHash() {
        return this.hash;
    } 
}