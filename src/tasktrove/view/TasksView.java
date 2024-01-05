/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasktrove.view;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tasktrove.controller.TaskController;
import tasktrove.model.User;
import tasktrove.config.Database;
import tasktrove.model.Task;

/**
 *
 * @author riakgu
 */
public class TasksView extends javax.swing.JPanel {

    private TaskController tc = new TaskController();
    private User user;
    
    String[] columnNames = {"Task Id", "Task Name", "Description", "Started", "Deadline", "Status"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    /**
     * Creates new form TasksView
     */
    public TasksView(User user) {
        initComponents();
        this.user = user;
        
        tc.taskList(model, user.getUser_id());
        
        deleteTaskButton.setVisible(false);
        editTaskButton.setVisible(false);

        taskListTable.setBackground(new Color(242, 247, 255));
        jScrollPane4.getViewport().setBackground(new Color(242, 247, 255));
        taskListTable.getTableHeader().setBackground(new Color(242, 247, 255));
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        taskList = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taskListTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        createTaskButton = new javax.swing.JButton();
        editTaskButton = new javax.swing.JButton();
        deleteTaskButton = new javax.swing.JButton();
        createTask = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inputTNameField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputDescField = new javax.swing.JTextArea();
        submitCreateButton = new javax.swing.JButton();
        inputStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        inputStarted = new com.toedter.calendar.JDateChooser();
        inputDeadline = new com.toedter.calendar.JDateChooser();
        editTask = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        inputTNameField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputDescField2 = new javax.swing.JTextArea();
        submitEditButton = new javax.swing.JButton();
        inputStatus2 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        inputDeadline2 = new com.toedter.calendar.JDateChooser();
        inputStarted2 = new com.toedter.calendar.JDateChooser();

        setMaximumSize(new java.awt.Dimension(920, 585));
        setMinimumSize(new java.awt.Dimension(920, 585));
        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        taskList.setBackground(new java.awt.Color(255, 255, 255));
        taskList.setMaximumSize(new java.awt.Dimension(920, 585));
        taskList.setMinimumSize(new java.awt.Dimension(920, 585));

        jScrollPane4.setBackground(new java.awt.Color(242, 247, 255));

        taskListTable.setModel(model);
        taskListTable.setGridColor(new java.awt.Color(242, 247, 255));
        taskListTable.setSelectionBackground(new java.awt.Color(242, 247, 255));
        taskListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taskListTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(taskListTable);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Task List");

        createTaskButton.setText("Create Task");
        createTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTaskButtonActionPerformed(evt);
            }
        });

        editTaskButton.setText("Edit Task");
        editTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTaskButtonActionPerformed(evt);
            }
        });

        deleteTaskButton.setText("Delete Task");
        deleteTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTaskButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout taskListLayout = new javax.swing.GroupLayout(taskList);
        taskList.setLayout(taskListLayout);
        taskListLayout.setHorizontalGroup(
            taskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskListLayout.createSequentialGroup()
                .addGroup(taskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(taskListLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteTaskButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editTaskButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createTaskButton))
                    .addGroup(taskListLayout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        taskListLayout.setVerticalGroup(
            taskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskListLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(taskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(createTaskButton)
                    .addComponent(editTaskButton)
                    .addComponent(deleteTaskButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        mainPanel.add(taskList, "card2");

        createTask.setBackground(new java.awt.Color(255, 255, 255));
        createTask.setMaximumSize(new java.awt.Dimension(912, 585));
        createTask.setMinimumSize(new java.awt.Dimension(912, 585));

        jLabel1.setText("Task Name");

        jLabel2.setText("Started");

        jLabel3.setText("Status");

        jLabel5.setText("Deadline");

        jLabel6.setText("Description");

        inputTNameField.setBackground(new java.awt.Color(242, 247, 255));

        inputDescField.setBackground(new java.awt.Color(242, 247, 255));
        inputDescField.setColumns(20);
        inputDescField.setRows(5);
        jScrollPane1.setViewportView(inputDescField);

        submitCreateButton.setText("Submit");
        submitCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitCreateButtonActionPerformed(evt);
            }
        });

        inputStatus.setBackground(new java.awt.Color(242, 247, 255));
        inputStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TO_DO", "IN_PROGRESS", "DONE" }));
        inputStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputStatusActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Create Task");

        inputStarted.setBackground(new java.awt.Color(242, 247, 255));
        inputStarted.setDateFormatString("yyyy-MM-dd");

        inputDeadline.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout createTaskLayout = new javax.swing.GroupLayout(createTask);
        createTask.setLayout(createTaskLayout);
        createTaskLayout.setHorizontalGroup(
            createTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createTaskLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(createTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createTaskLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(782, 782, 782))
                        .addGroup(createTaskLayout.createSequentialGroup()
                            .addGroup(createTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(createTaskLayout.createSequentialGroup()
                                    .addGroup(createTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addComponent(inputTNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(createTaskLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(366, 366, 366)))
                            .addGroup(createTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(inputStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(createTaskLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(createTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(createTaskLayout.createSequentialGroup()
                                .addComponent(inputStarted, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(createTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(inputDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(submitCreateButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31))
        );
        createTaskLayout.setVerticalGroup(
            createTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createTaskLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addGap(31, 31, 31)
                .addGroup(createTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addGroup(createTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(inputTNameField))
                .addGap(18, 18, 18)
                .addGroup(createTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(createTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputStarted, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(submitCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );

        mainPanel.add(createTask, "card2");

        editTask.setBackground(new java.awt.Color(255, 255, 255));
        editTask.setMaximumSize(new java.awt.Dimension(912, 585));
        editTask.setMinimumSize(new java.awt.Dimension(912, 585));

        jLabel8.setText("Task Name");

        jLabel9.setText("Started");

        jLabel10.setText("Status");

        jLabel11.setText("Deadline");

        jLabel12.setText("Description");

        inputTNameField2.setBackground(new java.awt.Color(242, 247, 255));

        inputDescField2.setBackground(new java.awt.Color(242, 247, 255));
        inputDescField2.setColumns(20);
        inputDescField2.setRows(5);
        jScrollPane2.setViewportView(inputDescField2);

        submitEditButton.setText("Submit");
        submitEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitEditButtonActionPerformed(evt);
            }
        });

        inputStatus2.setBackground(new java.awt.Color(242, 247, 255));
        inputStatus2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TO_DO", "IN_PROGRESS", "DONE" }));
        inputStatus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputStatus2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Edit Task");

        inputDeadline2.setBackground(new java.awt.Color(242, 247, 255));
        inputDeadline2.setDateFormatString("yyyy-MM-dd");

        inputStarted2.setBackground(new java.awt.Color(242, 247, 255));
        inputStarted2.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout editTaskLayout = new javax.swing.GroupLayout(editTask);
        editTask.setLayout(editTaskLayout);
        editTaskLayout.setHorizontalGroup(
            editTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editTaskLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(editTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(submitEditButton)
                    .addGroup(editTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12)
                        .addGroup(editTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editTaskLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(794, 794, 794))
                            .addGroup(editTaskLayout.createSequentialGroup()
                                .addGroup(editTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(editTaskLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(editTaskLayout.createSequentialGroup()
                                        .addGroup(editTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(inputStarted2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inputTNameField2, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                                        .addGap(0, 9, Short.MAX_VALUE)))
                                .addGroup(editTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(inputStatus2, 0, 445, Short.MAX_VALUE)
                                    .addComponent(inputDeadline2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(4, 4, 4)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        editTaskLayout.setVerticalGroup(
            editTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editTaskLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel13)
                .addGap(31, 31, 31)
                .addGroup(editTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(5, 5, 5)
                .addGroup(editTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputStatus2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(inputTNameField2))
                .addGap(18, 18, 18)
                .addGroup(editTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(3, 3, 3)
                .addGroup(editTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputDeadline2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(inputStarted2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(submitEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );

        mainPanel.add(editTask, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void createTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTaskButtonActionPerformed
        mainPanel.removeAll();
        mainPanel.add(createTask);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_createTaskButtonActionPerformed

    private void submitCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitCreateButtonActionPerformed
        // Membaca nilai dari input field dan membuat objek Task
        Task task = new Task();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Mengatur nilai properti pada objek Task
        task.setUser_id(user);
        task.setTask_name(inputTNameField.getText());
        task.setDescription(inputDescField.getText());
        task.setStatus((String) inputStatus.getSelectedItem());

        try {
            // Mengatur tanggal mulai dan tanggal deadline pada objek Task
            task.setStarted(java.sql.Date.valueOf(sdf.format(inputStarted.getDate().getTime())));
            task.setDeadline(java.sql.Date.valueOf(sdf.format(inputDeadline.getDate().getTime())));
        } catch (NullPointerException e) {
            // Menampilkan pesan kesalahan jika tanggal mulai atau tanggal deadline kosong
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Memeriksa apakah ada field yang kosong pada objek Task
        if (task.getTask_name().isEmpty() || task.getDescription().isEmpty() || task.getStatus().isEmpty() || task.getStarted().toString().isEmpty() || task.getDeadline().toString().isEmpty()) {
            // Menampilkan pesan kesalahan jika ada field kosong
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Memeriksa apakah tanggal Started kurang dari atau sama dengan tanggal Deadline
        if (task.getStarted().compareTo(task.getDeadline()) > 0) {
            JOptionPane.showMessageDialog(this, "Start date must be on or before the deadline", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Menambahkan task baru dengan menggunakan TaskController (tc)
        if (tc.createTask(task)) {
            // Menampilkan pesan sukses jika penambahan task berhasil
            JOptionPane.showMessageDialog(this, "Task added successfully!");

            // Mengganti tampilan panel utama
            mainPanel.removeAll();
            mainPanel.add(taskList);
            mainPanel.repaint();
            mainPanel.revalidate();

            // Menghapus semua baris dalam model tabel
            int rowCount = model.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }

            // Memperbarui daftar tugas dalam tabel
            tc.taskList(model, user.getUser_id());
        }
    }//GEN-LAST:event_submitCreateButtonActionPerformed

    private void inputStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputStatusActionPerformed

    private void submitEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitEditButtonActionPerformed
        // Membaca nilai dari input field dan membuat objek Task untuk penyuntingan
        Task task = new Task();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Mengatur nilai properti pada objek Task
        task.setUser_id(user);
        task.setTask_id((int) model.getValueAt(taskListTable.getSelectedRow(), 0));
        task.setTask_name(inputTNameField2.getText());
        task.setDescription(inputDescField2.getText());
        task.setStatus((String) inputStatus2.getSelectedItem());

        try {
            // Mengatur tanggal mulai dan tanggal deadline pada objek Task
            task.setStarted(java.sql.Date.valueOf(sdf.format(inputStarted2.getDate().getTime())));
            task.setDeadline(java.sql.Date.valueOf(sdf.format(inputDeadline2.getDate().getTime())));
        } catch (NullPointerException e) {
            // Menampilkan pesan kesalahan jika tanggal mulai atau tanggal deadline kosong
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Memeriksa apakah ada field yang kosong pada objek Task
        if (task.getTask_name().isEmpty() || task.getDescription().isEmpty() || task.getStatus().isEmpty() || task.getStarted().toString().isEmpty() || task.getDeadline().toString().isEmpty()) {
            // Menampilkan pesan kesalahan jika ada field kosong
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Memeriksa apakah tanggal Started kurang dari atau sama dengan tanggal Deadline
        if (task.getStarted().compareTo(task.getDeadline()) > 0) {
            JOptionPane.showMessageDialog(this, "Start date must be on or before the deadline", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Menyunting tugas dengan menggunakan TaskController (tc)
        if (tc.editTask(task)) {
            // Menampilkan pesan sukses jika penyuntingan tugas berhasil
            JOptionPane.showMessageDialog(this, "Task updated successfully!");

            // Mengganti tampilan panel utama
            mainPanel.removeAll();
            mainPanel.add(taskList);
            mainPanel.repaint();
            mainPanel.revalidate();

            // Menghapus semua baris dalam model tabel
            int rowCount = model.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }

            // Memperbarui daftar tugas dalam tabel
            tc.taskList(model, user.getUser_id());
        }
    }//GEN-LAST:event_submitEditButtonActionPerformed

    private void inputStatus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputStatus2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputStatus2ActionPerformed

    private void editTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTaskButtonActionPerformed
        mainPanel.removeAll();
        mainPanel.add(editTask);
        mainPanel.repaint();
        mainPanel.revalidate();  
    }//GEN-LAST:event_editTaskButtonActionPerformed

    private void taskListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taskListTableMouseClicked
        Task task = new Task();
        task = tc.getTaskDetails((int) model.getValueAt(taskListTable.getSelectedRow(), 0));
        
        deleteTaskButton.setVisible(true);
        editTaskButton.setVisible(true);

        inputTNameField2.setText(task.getTask_name());
        inputStarted2.setDate(task.getStarted());
        inputDeadline2.setDate(task.getDeadline());
        inputDescField2.setText(task.getDescription());
        inputStatus2.setSelectedItem(task.getStatus()); 
    }//GEN-LAST:event_taskListTableMouseClicked

    private void deleteTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTaskButtonActionPerformed
        // Mendapatkan ID tugas yang dipilih dari baris yang dipilih
        int task_id = (int) model.getValueAt(taskListTable.getSelectedRow(), 0);

        // Menampilkan konfirmasi penghapusan tugas
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);

        // Memeriksa apakah pengguna mengonfirmasi penghapusan
        if (confirm == JOptionPane.YES_OPTION) {
            // Menghapus tugas menggunakan TaskController (tc)
            if (tc.deleteTask(task_id)) {
                // Menampilkan pesan sukses jika penghapusan tugas berhasil
                JOptionPane.showMessageDialog(this, "Task deleted successfully!");
                // Menghapus semua baris dalam model tabel
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    model.removeRow(i);
                }

                // Memperbarui daftar tugas dalam tabel
                tc.taskList(model, user.getUser_id());
            }
        }
    }//GEN-LAST:event_deleteTaskButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel createTask;
    private javax.swing.JButton createTaskButton;
    private javax.swing.JButton deleteTaskButton;
    private javax.swing.JPanel editTask;
    private javax.swing.JButton editTaskButton;
    private com.toedter.calendar.JDateChooser inputDeadline;
    private com.toedter.calendar.JDateChooser inputDeadline2;
    private javax.swing.JTextArea inputDescField;
    private javax.swing.JTextArea inputDescField2;
    private com.toedter.calendar.JDateChooser inputStarted;
    private com.toedter.calendar.JDateChooser inputStarted2;
    private javax.swing.JComboBox<String> inputStatus;
    private javax.swing.JComboBox<String> inputStatus2;
    private javax.swing.JTextField inputTNameField;
    private javax.swing.JTextField inputTNameField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton submitCreateButton;
    private javax.swing.JButton submitEditButton;
    private javax.swing.JPanel taskList;
    private javax.swing.JTable taskListTable;
    // End of variables declaration//GEN-END:variables
}
