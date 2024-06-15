package usjt.medicalsys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class pacienteClass extends medicoClass {

    //Appointment var:
    private String data_hora;
    private String motivo_C;

    //Paciente Methods:
    public void registerPaciente() {

        String sql = "INSERT INTO paciente(nome, email, senha, cpf, telefone) VALUES (?, ?, ?, ?, ?) ";

        ConnectionFactory nConnection = new ConnectionFactory();

        try ( Connection c = nConnection.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, getNome());
            ps.setString(2, getEmail());
            ps.setString(3, getSenha());
            ps.setString(4, getCpf());
            ps.setString(5, getTelefone());

            ps.execute();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void updatePaciente() {

        String sql = "UPDATE paciente SET nome = ?, email = ?, senha = ?, cpf = ?, telefone = ? WHERE paciente_id = ? ";

        ConnectionFactory nConnection = new ConnectionFactory();

        try ( Connection c = nConnection.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, getNome());
            ps.setString(2, getEmail());
            ps.setString(3, getSenha());
            ps.setString(4, getCpf());
            ps.setString(5, getTelefone());
            ps.setInt(6, getPaciente_id());

            ps.execute();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void viewPaciente() {

        String sql = "SELECT * FROM paciente WHERE paciente_id = ? ";

        ConnectionFactory nConnection = new ConnectionFactory();

        try ( Connection c = nConnection.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, getPaciente_id());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String pacienteInfo
                        = "<html>"
                        + "Paciente ID: " + rs.getInt("paciente_id") + "<br>"
                        + "Nome: " + rs.getString("nome") + "<br>"
                        + "Email: " + rs.getString("email") + "<br>"
                        + "Senha: " + rs.getString("senha") + "<br>"
                        + "CPF: " + rs.getString("cpf") + "<br>"
                        + "Telefone: " + rs.getString("telefone")
                        + "</html>";

                SwingUtilities.invokeLater(() -> showPatientInfo(pacienteInfo));

            } else {

                SwingUtilities.invokeLater(() -> showPatientInfo("Nenhum paciente encontrado com o  paciente_id: " + getPaciente_id()));

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    private void showPatientInfo(String pacienteInfo) {

        JFrame frame = new JFrame("Informações do Paciente");
        JPanel panel = new JPanel();
        JLabel label = new JLabel(pacienteInfo);

        panel.add(label);
        frame.add(panel);
        frame.setSize(900, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    public void deletePaciente() {

        String sql = "DELETE FROM paciente WHERE paciente_id = ? ";

        ConnectionFactory nConnection = new ConnectionFactory();

        try ( Connection c = nConnection.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, getPaciente_id());

            ps.execute();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    //Appointment Methods:
    public void newConsulta() {

        String sql = "INSERT INTO consulta(data_hora, motivo_C, medico_id, paciente_id) VALUES (?, ?, ?, ?) ";

        ConnectionFactory nConnection = new ConnectionFactory();

        try ( Connection c = nConnection.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, getData_hora());
            ps.setString(2, getMotivo_C());
            ps.setInt(3, getMedico_id());
            ps.setInt(4, getPaciente_id());

            ps.execute();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void updateConsulta() {

        String sql = "UPDATE consulta SET data_hora = ?, motivo_C = ?, medico_id = ?, paciente_id = ? WHERE consulta_id = ? ";

        ConnectionFactory nConnection = new ConnectionFactory();

        try ( Connection c = nConnection.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, getData_hora());
            ps.setString(2, getMotivo_C());
            ps.setInt(3, getMedico_id());
            ps.setInt(4, getPaciente_id());
            ps.setInt(5, getConsulta_id());

            ps.execute();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    //Consulta methods:
    public void viewConsulta() {

        String sql = "SELECT * FROM consulta WHERE consulta_id = ? ";

        ConnectionFactory nConnection = new ConnectionFactory();

        try ( Connection c = nConnection.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, getConsulta_id());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String consultaInfo
                        = "<html>"
                        + "Consulta ID: " + rs.getInt("consulta_id") + "<br>"
                        + "Data e hora: " + rs.getString("data_hora") + "<br>"
                        + "Motivo da Consulta: " + rs.getString("motivo_C") + "<br>"
                        + "Médico: " + rs.getString("medico_id") + "<br>"
                        + "Paciente: " + rs.getString("paciente_id")
                        + "</html>";

                SwingUtilities.invokeLater(() -> showConsultaInfo(consultaInfo));

            } else {

                SwingUtilities.invokeLater(() -> showConsultaInfo("Nenhum agendamento encontrado com a consulta_id: " + getConsulta_id()));

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    private void showConsultaInfo(String consultaInfo) {

        JFrame frame = new JFrame("Informações da consulta");
        JPanel panel = new JPanel();
        JLabel label = new JLabel(consultaInfo);

        panel.add(label);
        frame.add(panel);
        frame.setSize(900, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    public void deleteConsulta() {

        String sql = "DELETE FROM consulta WHERE consulta_id = ? ";

        ConnectionFactory nConnection = new ConnectionFactory();

        try ( Connection c = nConnection.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, getConsulta_id());

            ps.execute();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    //Getters and Setters:
    String getData_hora() {
        return data_hora;
    }

    void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    String getMotivo_C() {
        return motivo_C;
    }

    void setMotivo_C(String motivo_C) {
        this.motivo_C = motivo_C;
    }
}
