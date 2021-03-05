import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ejemplo extends JPanel
                          implements ItemListener {
    JRadioButton feliz;
    JRadioButton enojado;
    JRadioButton triste;

    JLabel pictureLabel;

    public ejemplo() {
        super(new BorderLayout());

        //Create the check boxes.
        feliz = new JRadioButton("Feliz");
        enojado = new JRadioButton("Enojado");
        triste = new JRadioButton("Triste");

        ButtonGroup group = new ButtonGroup();

        feliz.addItemListener(this);
        enojado.addItemListener(this);
        triste.addItemListener(this);


        pictureLabel = new JLabel();
        pictureLabel.setFont(pictureLabel.getFont().deriveFont(Font.ITALIC));
        updatePicture("normal");

        JPanel checkPanel = new JPanel(new GridLayout(0, 1));

        
        group.add(feliz);
        group.add(enojado);
        group.add(triste);

        checkPanel.add(feliz);
        checkPanel.add(enojado);
        checkPanel.add(triste);

        add(checkPanel, BorderLayout.EAST);
        add(pictureLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    public void itemStateChanged(ItemEvent e) {

        Object source = e.getItemSelectable();
        String estado = "";

        if(source == feliz) {
            estado = "feliz";
        } else if(source == enojado) {
            estado= "enojado";
        } else if (source == triste) {
            estado = "triste"; 
        }

        updatePicture(estado);
    }

    protected void updatePicture(String name) {
        //Get the icon corresponding to the image.
        ImageIcon icon = createImageIcon(
                                    "images/"
                                    + name
                                    + ".png");
        pictureLabel.setIcon(icon);
        pictureLabel.setToolTipText(name);
        if (icon == null) {
            pictureLabel.setText("No se encontro la imagen");
        } else {
            pictureLabel.setText(null);
        }
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ejemplo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("Perrito");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new ejemplo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

    
        frame.setLocation(600, 400);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
   
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}