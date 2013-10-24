/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package diuf.unifr.ch.rest.test1.actions;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.validator.annotations.Validation;
import diuf.unifr.ch.rest.test1.client.LPLTaskClient;
import diuf.unifr.ch.rest.test1.client.LPLTasksClient;
import diuf.unifr.ch.rest.test1domain.Task;
/**
 *
 * @author ruppena
 */
@Validation()
@Conversion()
public class TaskAction extends ActionSupport  {
    protected Task task;
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }
    

    public String execute() throws Exception {
        LPLTaskClient tc = new LPLTaskClient(id);
        task = tc.getXml(Task.class);
        tc.close();
        return SUCCESS;
    }

}
