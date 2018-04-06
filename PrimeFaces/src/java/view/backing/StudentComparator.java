/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.lang.reflect.Field;
import java.util.Comparator;
import models.Student;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Tomi
 */
public class StudentComparator implements Comparator<Student> {

    private final String sortField;
    private final SortOrder sortOrder;

    public StudentComparator(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Student student1, Student student2) {
        try {
            Field field = Student.class.getDeclaredField(sortField);
            field.setAccessible(true);     
            Object value1 = field.get(student1);
            Object value2 = field.get(student2);
            int result = ((Comparable) value1).compareTo(value2);
            return SortOrder.ASCENDING.equals(sortOrder) ? result : -1 * result;
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException ex) {
            throw new RuntimeException(ex);
        }
    }

}
