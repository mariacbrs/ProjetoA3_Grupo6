
package usjt.medicalsys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class medicoClass {
    
    //Doctors var
    private int medico_id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String telefone;
    private String especialidade;
    
    //Prescription var:
    private int prescricao_id;
    private String descricao;
    
    //paciente_id and consulta_id needs to be created here
    private int paciente_id;
    private int consulta_id;
    
    
    
    
   //Doctors methods:
    public void registerMedico(){
        String sql = "INSERT INTO medico(nome, email, senha, cpf, telefone, especialidade) VALUES (?, ?, ?, ?, ?, ?) ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setString(1,getNome());
          ps.setString(2,getEmail());
          ps.setString(3,getSenha());
          ps.setString(4,getCpf());
          ps.setString(5,getTelefone());
          ps.setString(6,getEspecialidade());
          ps.execute();
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
    public void updateMedico(){
        String sql = "UPDATE medico SET nome = ?, email = ?, senha = ?, cpf = ?, telefone = ?, especialidade = ? WHERE medico_id = ? ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setString(1,getNome());
          ps.setString(2,getEmail());
          ps.setString(3,getSenha());
          ps.setString(4,getCpf());
          ps.setString(5,getTelefone());
          ps.setString(6,getEspecialidade());
          ps.setInt(7,getMedico_id());
          ps.execute();
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
    public void deleteMedico(){
        String sql = "DELETE FROM medico WHERE medico_id = ? ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setInt(1,getMedico_id());
          ps.execute();
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
      public void viewMedico(){
        String sql = "SELECT * FROM medico WHERE medico_id = ? ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setInt(1,getMedico_id());
          ResultSet rs = ps.executeQuery();
          
          if(rs.next()){
              String medicoInfo = 
                    "<html>" + 
                        "Medico ID: " + rs.getInt("medico_id") + "<br>" +
                        "Nome: " + rs.getString("nome") + "<br>" +
                        "Email: " + rs.getString("email") + "<br>" +
                        "Senha: " + rs.getString("senha") + "<br>" +
                        "CPF: " + rs.getString("cpf") + "<br>" +
                        "Telefone: " + rs.getString("telefone") + "<br>" + 
                        "Especialidade: " + rs.getString("especialidade")
                  + "</html>";
               SwingUtilities.invokeLater(() -> showMedicoInfo(medicoInfo));
            } else {
                SwingUtilities.invokeLater(() -> showMedicoInfo("Nenhum medico encontrado com o medico_id: " + getMedico_id()));
            }
        }catch(Exception e){
         e.printStackTrace();
        }
    }
      
    private void showMedicoInfo(String medicoInfo) {
        JFrame frame = new JFrame("Informações do Médico");
        JPanel panel = new JPanel();
        JLabel label = new JLabel(medicoInfo);

        panel.add(label);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    
    // Prescription methods:
    
    
    //Appointment Methods:
   
        public void newPrescricao(){
        String sql = "INSERT INTO prescricao(descricao, medico_id, paciente_id, consulta_id) VALUES (?, ?, ?, ?) ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setString(1,getDescricao());
          ps.setInt(2,getMedico_id());
          ps.setInt(3,getPaciente_id());
          ps.setInt(4,getConsulta_id());
          ps.execute();
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
    public void updatePrescricao(){
        String sql = "UPDATE prescricao SET descricao = ?, medico_id = ?, paciente_id = ?, consulta_id = ? WHERE prescricao_id = ? ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setString(1,getDescricao());
          ps.setInt(2,getMedico_id());
          ps.setInt(3,getPaciente_id());
          ps.setInt(4,getConsulta_id());
          ps.setInt(5,getPrescricao_id());
          ps.execute();
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
    public void deletePrescricao(){
        String sql = "DELETE FROM prescricao WHERE prescricao_id = ? ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setInt(1,getPrescricao_id());
          ps.execute();
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
      public void viewPrescricao(){
        String sql = "SELECT * FROM prescricao WHERE prescricao_id = ? ";
         ConnectionFactory nConnection = new ConnectionFactory();
        try(Connection c= nConnection.obtemConexao()){
          PreparedStatement ps = c.prepareStatement(sql);
          ps.setInt(1,getPrescricao_id());
          ResultSet rs = ps.executeQuery();
          
          if(rs.next()){
              String prescricaoInfo = 
                    "<html>" + 
                        "Prescrição ID: " + rs.getInt("prescricao_id") + "<br>" +
                        "Descrição: " + rs.getString("descricao") + "<br>" +
                        "Médico ID: " + rs.getString("medico_id") + "<br>" +
                        "Paciente ID: " + rs.getString("paciente_id") + "<br>" +
                        "Consulta ID: " + rs.getString("consulta_id")
                  + "</html>";
               SwingUtilities.invokeLater(() -> showPrescricaoInfo(prescricaoInfo));
            } else {
                SwingUtilities.invokeLater(() -> showPrescricaoInfo("Nenhuma prescição encontrada com a prescricao_id: " + getPrescricao_id()));
            }
        }catch(Exception e){
         e.printStackTrace();
        }
    }
      
    private void showPrescricaoInfo(String prescricaoInfo) {
        JFrame frame = new JFrame("Informações da Prescrição");
        JPanel panel = new JPanel();
        JLabel label = new JLabel(prescricaoInfo);

        panel.add(label);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    
     int getMedico_id() {
        return medico_id;
    }

    private void setMedico_id(int medico_id) {
        this.medico_id = medico_id;
    }


    private String getNome() {
        return nome;
    }


    private void setNome(String nome) {
        this.nome = nome;
    }

 
    private String getEmail() {
        return email;
    }

 
    private void setEmail(String email) {
        this.email = email;
    }

 
    private String getSenha() {
        return senha;
    }


    private void setSenha(String senha) {
        this.senha = senha;
    }


    private String getCpf() {
        return cpf;
    }


    private void setCpf(String cpf) {
        this.cpf = cpf;
    }


    private String getTelefone() {
        return telefone;
    }


    private void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    private String getEspecialidade() {
        return especialidade;
    }


    private void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

 
    private int getPrescricao_id() {
        return prescricao_id;
    }

    private void setPrescricao_id(int prescricao_id) {
        this.prescricao_id = prescricao_id;
    }


    private String getDescricao() {
        return descricao;
    }


    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    int getPaciente_id() {
        return paciente_id;
    }

    private void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
    }
    

    int getConsulta_id() {
        return consulta_id;
    }

    private void setConsulta_id(int consulta_id) {
        this.consulta_id = consulta_id;
    }
    
}
