package view.backing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import models.Student;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author Tomi
 */
@ManagedBean
public class TableView {
    
    @ManagedProperty("#{studentsLazyDataModel}")
    private LazyDataModel<Student> dataModel;
    
    public LazyDataModel<Student> getLazyModel() {
        return getDataModel();
    }

    /**
     * @return the dataModel
     */
    public LazyDataModel<Student> getDataModel() {
        return dataModel;
    }

    /**
     * @param dataModel the dataModel to set
     */
    public void setDataModel(LazyDataModel<Student> dataModel) {
        this.dataModel = dataModel;
    }
    
}
