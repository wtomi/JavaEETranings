/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import models.Student;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Tomi
 */
@ManagedBean(name = "studentsLazyDataModel")
@ApplicationScoped
public class StudentsLazyModel extends LazyDataModel<Student> {

    private final List<Student> studentsDatasource;

    Random rand = new Random();

    public StudentsLazyModel() {
        studentsDatasource = Arrays.asList(
                new Student(getRandomId(), "Danuta Paszek", gerRandomAverage()),
                new Student(getRandomId(), "Lena Adamczak", gerRandomAverage()),
                new Student(getRandomId(), "Liliana Sobol", gerRandomAverage()),
                new Student(getRandomId(), "Alicja Niemczyk", gerRandomAverage()),
                new Student(getRandomId(), "Edward Sokół", gerRandomAverage()),
                new Student(getRandomId(), "Zygmunt Klimek", gerRandomAverage())
        );
    }

    private double gerRandomAverage() {
        return 3 + rand.nextDouble() * 2;
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    @Override
    public Student getRowData(String rowKey) {
        return studentsDatasource.stream()
                .filter(s -> s.getKey().equals(rowKey))
                .findAny()
                .orElse(null);
    }

    @Override
    public Object getRowKey(Student student) {
        return student.getKey();
    }

    @Override
    public List<Student> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List<Student> data;
        if (sortField != null) {
            data = studentsDatasource.stream()
                    .sorted(new StudentComparator(sortField, sortOrder))
                    .collect(Collectors.toList());
        } else {
            data = studentsDatasource;
        }

        int dataSize = data.size();
        this.setRowCount(dataSize);

        if (dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            } catch (IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        } else {
            return data;
        }
    }
}
