package travelagency.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Dimension;
// import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;
import travelagency.*;

public class RouteForm extends JFrame {
    private JPanel panelSup, panelInf, panelTabla, panelBoton, panelRuta1, panelRuta2, panelHora1, panelHora2,
            panelFecha, panelContFecha, panelListadoRec, panelBotonGuardar;
    private JButton agregarRecorrido, guardarRuta;
    private JTextField origenPpal, destinoPpal, origen1, destino1, dia;
    // private JTable tablaRecorridos;
    private JComboBox<String> horas1, horas2, minutos1, minutos2, mes;
    private JLabel textoFecha;
    private JTextArea mostrarRecorridos;
    private ArrayList<Tour> tourList;
    travelagency.TravelAgency myAgency;

    String horas[] = {
            "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
            "20", "21", "22", "23", "24"
    };

    String minutos[] = {
            "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
            "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
            "30", "31", "32", "33", "34", "35", "36", "37", "38", "39",
            "40", "41", "42", "43", "44", "45", "46", "47", "48", "49",
            "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"
    };

    String meses[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

    public RouteForm(travelagency.TravelAgency agency) {
        this.myAgency = agency;
        this.tourList = new ArrayList<Tour>();

        iniciarComponentes();
    }

    public void iniciarComponentes() {
        // Se configuran propiedades del frame
        setTitle("Add route");
        setSize(800, 450);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        this.panelSup = new JPanel(new GridLayout(1, 2));
        this.configurarCamposTexto();

        this.panelInf = new JPanel(new GridLayout(5, 1));

        this.panelContFecha = new JPanel(new GridLayout(1, 2));
        this.configurarFecha();

        this.panelTabla = new JPanel(new GridLayout(1, 2));
        this.configurarRecorridos();

        this.panelBoton = new JPanel();
        this.panelBotonGuardar = new JPanel();
        this.configurarBotones();

        this.panelListadoRec = new JPanel();
        this.mostrarRecorridos = new JTextArea();
        this.mostrarRecorridos.setEditable(false);
        this.panelListadoRec.add(this.mostrarRecorridos);

        this.panelInf.add(this.panelContFecha);
        this.panelInf.add(this.panelTabla);
        this.panelInf.add(this.panelBoton);
        this.panelInf.add(this.panelListadoRec);
        this.panelInf.add(this.panelBotonGuardar);

        this.add(this.panelSup, BorderLayout.NORTH);
        this.add(this.panelInf, BorderLayout.SOUTH);

        Border grayRoundedBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
        this.panelInf.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Tour details"));
        this.panelInf.setPreferredSize(new Dimension(800, 365));
        this.panelBoton.setPreferredSize(new Dimension(800, 25));
        this.panelContFecha.setPreferredSize(new Dimension(800, 30));
        this.panelListadoRec.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Tour list"));
    }

    public void configurarBotones() {
        this.agregarRecorrido = new JButton("Add tour");
        this.guardarRuta = new JButton("Save route");
        this.panelBoton.add(this.agregarRecorrido);
        this.panelBotonGuardar.add(this.guardarRuta);
        this.agregarRecorrido.addActionListener(ev -> this.guardarRecorrido());
        this.guardarRuta.addActionListener(ev -> this.guardarRuta());
    }

    public void configurarCamposTexto() {
        this.origenPpal = new JTextField();
        this.destinoPpal = new JTextField();
        this.panelSup.add(this.origenPpal);
        this.panelSup.add(this.destinoPpal);
        Border grayRoundedBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
        this.origenPpal.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Principal origin"));
        this.destinoPpal.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Principal destination"));
    }

    public void configurarRecorridos() {
        // this.tablaRecorridos = new JTable();
        // ArrayList<Tour> recorridos;
        Border grayRoundedBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
        this.panelRuta1 = new JPanel(new GridLayout(1, 2, 5, 5));
        this.origen1 = new JTextField();
        this.panelRuta1.add(this.origen1);
        this.panelHora1 = new JPanel(new GridLayout(1, 2, 5, 5));
        this.horas1 = new JComboBox<String>(this.horas);
        this.minutos1 = new JComboBox<String>(this.minutos);
        this.panelHora1.add(this.horas1);
        this.panelHora1.add(this.minutos1);
        this.panelRuta1.add(this.panelHora1);
        this.panelTabla.add(panelRuta1);

        this.panelRuta2 = new JPanel(new GridLayout(1, 2, 5, 5));
        this.destino1 = new JTextField();
        this.panelRuta2.add(this.destino1);
        this.panelHora2 = new JPanel(new GridLayout(1, 2, 5, 5));
        this.horas2 = new JComboBox<String>(this.horas);
        this.minutos2 = new JComboBox<String>(this.minutos);
        this.panelHora2.add(this.horas2);
        this.panelHora2.add(this.minutos2);
        this.panelRuta2.add(this.panelHora2);
        this.panelTabla.add(panelRuta2);

        this.panelRuta1.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Origin place"));
        this.panelRuta2.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Destination place"));
        this.origen1.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "City name"));
        this.destino1.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "City name"));
        this.panelHora1.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Time"));
        this.panelHora2.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Time"));
    }

    public void configurarFecha() {
        Border grayRoundedBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
        this.textoFecha = new JLabel("Enter the date of the trip: ");
        this.panelContFecha.add(this.textoFecha);

        this.dia = new JTextField(2);
        this.mes = new JComboBox<String>(meses);
        this.dia = new JTextField(2);
        this.mes = new JComboBox<String>(meses);

        this.panelFecha = new JPanel(new GridLayout(1, 2));
        this.panelFecha.add(this.dia);
        this.panelFecha.add(this.mes);
        this.panelContFecha.add(this.panelFecha);

        this.panelContFecha.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Date"));
        this.dia.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Day (NUMBER)"));
        this.mes.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Month"));
    }

    public void guardarRecorrido() {
        String fechaRec = this.dia.getText() + " " + this.mes.getSelectedItem().toString();
        String origen = this.origen1.getText();
        String destino = this.destino1.getText();
        String horaSalida = this.horas1.getSelectedItem().toString() + ":" + this.minutos1.getSelectedItem().toString();
        String horaLlegada = this.horas2.getSelectedItem().toString() + ":"
                + this.minutos2.getSelectedItem().toString();

        if (fechaRec.isEmpty() || origen.isEmpty() || destino.isEmpty() || horaSalida.isEmpty()
                || horaLlegada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You must fill in all the fields");
        } else if (!this.validarDia(this.dia.getText())) {
            JOptionPane.showMessageDialog(null, "The value <<Day>> is not valid");
        } else {
            Tour tour = new Tour(fechaRec, origen, destino, horaSalida, horaLlegada);
            this.tourList.add(tour);
            String data = "";
            for (int i = 0; i < this.tourList.size(); i++) {
                data += this.tourList.get(i).getOrigin() + " - " + this.tourList.get(i).getDestination() + ", "
                        + this.tourList.get(i).getDate() + "  " + this.tourList.get(i).getDeparture() + " - "
                        + this.tourList.get(i).getArrival() + "\n";
            }
            this.mostrarRecorridos.setText(data);
        }
    }

    public void guardarRuta() {
        String origen = this.origenPpal.getText();
        String destino = this.destinoPpal.getText();
        if (origen.isEmpty() || destino.isEmpty() || this.tourList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You must fill in all the fields");
        } else {
            Route newRoute = new Route(origen, destino, this.tourList);
            this.myAgency.addRoute(newRoute);
            this.setVisible(false);
            this.myAgency.setVisible(true);
        }
    }

    public Boolean validarDia(String num) {
        try {
            Integer number = Integer.parseInt(num);
            if (number < 1 || number > 31) {
                return false;
            } else if (this.mes.getSelectedItem().toString() == "Feb" && number > 29) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
