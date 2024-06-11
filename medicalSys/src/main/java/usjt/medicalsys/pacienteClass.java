
package usjt.medicalsys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class pacienteClass extends medicoClass {
    //Pacient var:    
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String telefone;
    
    //Appointment var:
    private String data_hora;
    private String motivo_C;
    

    //Pacient Methods:
    
    public void registerPacient(){
        String sql = "INSERT INTO paciente(nome, email, senha, cpf, telefone) VALUES (?, ?, ?, ?, ?) ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setString(1,getNome());
          ps.setString(2,getEmail());
          ps.setString(3,getSenha());
          ps.setString(4,getCpf());
          ps.setString(5,getTelefone());
          ps.execute();
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
    public void updatePacient(){
        String sql = "UPDATE paciente SET nome = ?, email = ?, senha = ?, cpf = ?, telefone = ? WHERE paciente_id = ? ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setString(1,getNome());
          ps.setString(2,getEmail());
          ps.setString(3,getSenha());
          ps.setString(4,getCpf());
          ps.setString(5,getTelefone());
          ps.setInt(6,getPaciente_id());
          ps.execute();
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
    public void deletePacient(){
        String sql = "DELETE FROM paciente WHERE paciente_id = ? ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setInt(1,getPaciente_id());
          ps.execute();
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
      public void viewPacient(){
        String sql = "SELECT * FROM paciente WHERE paciente_id = ? ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setInt(1,getPaciente_id());
          ResultSet rs = ps.executeQuery();
          
          if(rs.next()){
              String pacientInfo = 
                    "<html>" + 
                        "Paciente ID: " + rs.getInt("paciente_id") + "<br>" +
                        "Nome: " + rs.getString("nome") + "<br>" +
                        "Email: " + rs.getString("email") + "<br>" +
                        "Senha: " + rs.getString("senha") + "<br>" +
                        "CPF: " + rs.getString("cpf") + "<br>" +
                        "Telefone: " + rs.getString("telefone") 
                  + "</html>";
               SwingUtilities.invokeLater(() -> showPatientInfo(pacientInfo));
            } else {
                SwingUtilities.invokeLater(() -> showPatientInfo("Nenhum paciente encontrado com o  paciente_id: " + getPaciente_id()));
            }
        }catch(Exception e){
         e.printStackTrace();
        }
    }
      
    private void showPatientInfo(String pacienteInfo) {
        JFrame frame = new JFrame("Informações do Paciente");
        JPanel panel = new JPanel();
        JLabel label = new JLabel(pacienteInfo);

        panel.add(label);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    } 
    
    //Appointment Methods:
   
        public void newConsulta(){
        String sql = "INSERT INTO consulta(data_hora, motivo_C, medico_id, paciente_id) VALUES (?, ?, ?, ?) ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setString(1,getData_hora());
          ps.setString(2,getMotivo_C());
          ps.setInt(3,getMedico_id());
          ps.setInt(4,getPaciente_id());
          ps.execute();
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
    public void updateConsulta(){
        String sql = "UPDATE consulta SET data_hora = ?, motivo_C = ?, medico_id = ?, paciente_id = ? WHERE consulta_id = ? ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setString(1,getData_hora());
          ps.setString(2,getMotivo_C());
          ps.setInt(3,getMedico_id());
          ps.setInt(4,getPaciente_id());
          ps.setInt(5,getConsulta_id());
          ps.execute();
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
    public void deleteConsulta(){
        String sql = "DELETE FROM consulta WHERE consulta_id = ? ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setInt(1,getConsulta_id());
          ps.execute();
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
      public void viewConsulta(){
        String sql = "SELECT * FROM consulta WHERE consulta_id = ? ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setInt(1,getConsulta_id());
          ResultSet rs = ps.executeQuery();
          
          if(rs.next()){
              String consultaInfo = 
                    "<html>" + 
                        "Consulta ID: " + rs.getInt("consulta_id") + "<br>" +
                        "Data e hora: " + rs.getString("data_hora") + "<br>" +
                        "Motivo da Consulta: " + rs.getString("motivo_C") + "<br>" +
                        "Médico: " + rs.getString("medico_id") + "<br>" +
                        "Paciente: " + rs.getString("paciente_id")
                  + "</html>";
               SwingUtilities.invokeLater(() -> showConsultaInfo(consultaInfo));
            } else {
                SwingUtilities.invokeLater(() -> showConsultaInfo("Nenhum agendamento encontrado com a consulta_id: " + getConsulta_id()));
            }
        }catch(Exception e){
         e.printStackTrace();
        }
    }
      
    private void showConsultaInfo(String consultaInfo) {
        JFrame frame = new JFrame("Informações da consulta");
        JPanel panel = new JPanel();
        JLabel label = new JLabel(consultaInfo);

        panel.add(label);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }  
    
    
    //Getters and Setters:
 
    private String getNome() {
        return nome;
    }

 
     void setNome(String nome) {
        this.nome = nome;
    }

  
    private String getEmail() {
        return email;
    }

  
      void setEmail(String email) {
        this.email = email;
    }

   
    private String getSenha() {
        return senha;
    }

  
    void setSenha(String senha) {
        this.senha = senha;
    }

  
    private String getCpf() {
        return cpf;
    }

  
    void setCpf(String cpf) {
        this.cpf = cpf;
    }


    private String getTelefone() {
        return telefone;
    }

  
    void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    private String getData_hora() {
        return data_hora;
    }

    private void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    private String getMotivo_C() {
        return motivo_C;
    }

    private void setMotivo_C(String motivo_C) {
        this.motivo_C = motivo_C;
    }
}

