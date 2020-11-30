
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author binh3920
 */
public class QuizSlangFrame extends javax.swing.JFrame {

    /**
     * Creates new form Qu
     */
    private Dictionary myDict;
    private int right;
    
    public QuizSlangFrame() {
        initComponents();
    }
    
    public QuizSlangFrame(Dictionary myDict) {
        initComponents();
        this.myDict = myDict;
        this.right = makeNewQuiz();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        quizButton1 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        quizButton = new javax.swing.JButton();
        newQuizButton = new javax.swing.JButton();
        questionLabel = new javax.swing.JLabel();
        ansOne = new javax.swing.JRadioButton();
        ansThree = new javax.swing.JRadioButton();
        ansTwo = new javax.swing.JRadioButton();
        ansFour = new javax.swing.JRadioButton();

        quizButton1.setBackground(new java.awt.Color(12, 158, 158));
        quizButton1.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        quizButton1.setForeground(new java.awt.Color(255, 255, 255));
        quizButton1.setText("Submit");
        quizButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quizzzzz");
        setPreferredSize(new java.awt.Dimension(600, 400));
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Andale Mono", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(110, 186, 182));
        jLabel1.setText("Quiz Slang");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        quizButton.setBackground(new java.awt.Color(12, 158, 158));
        quizButton.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        quizButton.setForeground(new java.awt.Color(255, 255, 255));
        quizButton.setText("Submit");
        quizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizButtonActionPerformed(evt);
            }
        });
        getContentPane().add(quizButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 296, 135, 47));

        newQuizButton.setBackground(new java.awt.Color(12, 158, 158));
        newQuizButton.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        newQuizButton.setForeground(new java.awt.Color(255, 255, 255));
        newQuizButton.setText("New quiz");
        newQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newQuizButtonActionPerformed(evt);
            }
        });
        getContentPane().add(newQuizButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 296, 135, 47));

        questionLabel.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        questionLabel.setText("Question:");
        getContentPane().add(questionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        buttonGroup1.add(ansOne);
        ansOne.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        ansOne.setText("jRadioButton1");
        ansOne.setActionCommand("1");
        ansOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansOneActionPerformed(evt);
            }
        });
        getContentPane().add(ansOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        buttonGroup1.add(ansThree);
        ansThree.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        ansThree.setText("jRadioButton2");
        ansThree.setActionCommand("3");
        getContentPane().add(ansThree, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        buttonGroup1.add(ansTwo);
        ansTwo.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        ansTwo.setText("jRadioButton3");
        ansTwo.setActionCommand("2");
        getContentPane().add(ansTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        buttonGroup1.add(ansFour);
        ansFour.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        ansFour.setText("jRadioButton4");
        ansFour.setActionCommand("4");
        getContentPane().add(ansFour, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 253, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizButtonActionPerformed
        int type = Integer.parseInt(buttonGroup1.getSelection().getActionCommand());
        System.out.println(type);
        System.out.println(this.right);
        if (type - 1 == this.right) {
            JOptionPane.showMessageDialog(null, "Your answer is correct!");
            buttonGroup1.clearSelection();
            this.right = makeNewQuiz();
        } else {
            JOptionPane.showMessageDialog(null, "You are wrong!");
        }
    }//GEN-LAST:event_quizButtonActionPerformed

    private void quizButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizButton1ActionPerformed

    }//GEN-LAST:event_quizButton1ActionPerformed

    private void newQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newQuizButtonActionPerformed
        this.right = makeNewQuiz();
        
    }//GEN-LAST:event_newQuizButtonActionPerformed

    private void ansOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansOneActionPerformed

    }//GEN-LAST:event_ansOneActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuizSlangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizSlangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizSlangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizSlangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizSlangFrame().setVisible(true);
            }
        });
    }
    
    private int makeNewQuiz() {
        buttonGroup1.clearSelection();
        String slang = myDict.randomSlang();
        questionLabel.setText("Question: What \"" + slang + "\" mean?" );
        
        List<String> listDef = myDict.getValue(slang);
        
        for (int i = 0; i < 4; i++) {
            String anotherSlang = myDict.randomSlang();
            while (anotherSlang.equals(slang)) {
                anotherSlang = myDict.randomSlang();
            }
            List<String> listDefWrong =  myDict.getValue(anotherSlang);
            if (i == 0) {
                ansOne.setText(listDefWrong.get(0));
            } else if (i == 1) {
                ansTwo.setText(listDefWrong.get(0));
            } else if (i == 2) {
                ansThree.setText(listDefWrong.get(0));
            } else {
                ansFour.setText(listDefWrong.get(0));
            }
        }
        
        Random rand = new Random();
        int randomValue = rand.nextInt(4);
        if (randomValue == 0) {
            ansOne.setText(listDef.get(0));
        } else if (randomValue == 1) {
            ansTwo.setText(listDef.get(0));
        } else if (randomValue == 2) {
            ansThree.setText(listDef.get(0));
        } else {
            ansFour.setText(listDef.get(0));
        }
        
        return randomValue;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ansFour;
    private javax.swing.JRadioButton ansOne;
    private javax.swing.JRadioButton ansThree;
    private javax.swing.JRadioButton ansTwo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton newQuizButton;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JButton quizButton;
    private javax.swing.JButton quizButton1;
    // End of variables declaration//GEN-END:variables
}
