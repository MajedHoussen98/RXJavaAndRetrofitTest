package ps.ns.rxjavatest.network.asp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantModel {

    @SerializedName("id")
    @Expose
    String id;

    @SerializedName("name")
    @Expose
    String title;

    @SerializedName("address")
    @Expose
    String body;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
