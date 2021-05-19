package csulb.cecs323.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderNumber {
    @Id
    private int id;

    @OneToMany(mappedBy = "orderNumber")
    private List<Step> steps = new ArrayList<>();

    public OrderNumber(int id) {
        this.id = id;
    }

    public OrderNumber() {

    }

    public int getId() {
        return id;
    }

    public void setId(int stepId) {
        this.id = stepId;
    }



}

