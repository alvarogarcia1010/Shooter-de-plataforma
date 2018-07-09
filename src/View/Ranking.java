/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controllers.Dao.PartidasDao;
import Controllers.Dao.RankingDao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ryane
 */
public class Ranking extends JFrame{
    
    public static int height = 620;
    public static int width = 900;
    PanelRanking fondo = new PanelRanking();
    JButton regresar = new JButton();
    JTable top;
    JPanel table;
    DefaultTableModel tm;
    
    public Ranking(){
        super("Ranking");
        initialcomponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        add(fondo);
        llenarTabla();
        setVisible(true);
      }
      
    public void initialcomponents(){
        regresar = new JButton(new ImageIcon("regresar.png"));
        regresar.setBounds(20, 5, 50, 50);
        this.table = new JPanel();
        this.top = new JTable();
        top.setBounds(25,250,800,200);
        table.setBounds(25,250,800,200);
        JScrollPane scrollPane = new JScrollPane(top);
        scrollPane.setBounds(25, 250, 800, 200);
        table.add(scrollPane);
        Container container = getContentPane();
        container.add(regresar);
        container.add(table);
        regresar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Bienvenida b = new Bienvenida();
                b.setVisible(false);
                dispose();  
            }
        });
    }
    
    public void llenarTabla(){
        tm = new DefaultTableModel(){
            public Class<?> getColumnClass(int column){
                switch (column){
                    case 0:
                        return Integer.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }  
            
        };
        tm.addColumn("N°");
        tm.addColumn("Nombre");
        tm.addColumn("Personaje");
        tm.addColumn("Puntuacion");
        tm.addColumn("Tiempo");
        
        RankingDao partidas = new RankingDao();
        ArrayList<Modelo.Jugador.Ranking> top10;
        top10 = (ArrayList<Modelo.Jugador.Ranking>) partidas.top10();
        
        int i =1;
        for(Modelo.Jugador.Ranking p : top10){
            this.tm.addRow(new Object[]{i,p.getJugador(),p.getPersonaje(),p.getPuntuacion(),p.getTiempo()});
            i++;
        }
 
        top.setModel(tm);
    }
    
    private class PanelRanking extends JPanel{
    
        @Override
        public void paint(Graphics g){
            Dimension tamanio = getSize();
            ImageIcon image = new ImageIcon(getClass().getResource("/View/Components/b_3.png"));
            g.drawImage(image.getImage(), 0, 0, tamanio.width, tamanio.height, null);
            setOpaque(false);
            super.paint(g);
            }
    }
}

