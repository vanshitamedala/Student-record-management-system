import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentRecordApp {
    private List<Student> studentList = new ArrayList<>();
    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> studentListView;

    public StudentRecordApp() {
        frame = new JFrame("Student Record Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        listModel = new DefaultListModel<>();
        studentListView = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(studentListView);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextField nameField = new JTextField(15);
        JButton addButton = new JButton("Add Student");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentName = nameField.getText();
                if (!studentName.isEmpty()) {
                    Student student = new Student(studentName);
                    studentList.add(student);
                    listModel.addElement(student.getName());
                    nameField.setText("");
                }
            }
        });

        panel.add(nameField);
        panel.add(addButton);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentRecordApp();
            }
        });
    }

    class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
