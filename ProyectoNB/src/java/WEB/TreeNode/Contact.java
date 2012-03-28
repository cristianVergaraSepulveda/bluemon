package WEB.TreeNode;



public class Contact {
	private  String name;
	private  String category;
        private  Integer idSensor;
        private Integer idMicro;

    public Integer getIdMicro() {
        return idMicro;
    }

    public void setIdMicro(Integer idMicro) {
        this.idMicro = idMicro;
    }

	public Contact(String category) {
		this.category = category;
		this.name = null;
		this.profilepic = null;
                this.idSensor = null; 
	}

	public Contact(String name, String profilepic) {
		this.name = name;
		this.profilepic = profilepic;
		this.category = null;
                this.idSensor = null;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public String getProfilepic() {
		return profilepic;
	}

    public Integer getIdSensor() {
        return idSensor;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setIdSensor(Integer idSensor) {
        this.idSensor = idSensor;
    }

    public void setName(String name) {
        this.name = name;
    }

        
	private final String profilepic;
}
