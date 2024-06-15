package usjt.medicalsys;

import javax.swing.JOptionPane;

public class MedicalSys {

    static String nome;
    static String email;
    static String senha;
    static String cpf;
    static String telefone;

    static int medico_id;
    static String especialidade;
    static medicoClass medico = new medicoClass();

    static int paciente_id;
    static pacienteClass paciente = new pacienteClass();

    static String descricao;
    static int prescricao_id;

    static int consulta_id;
    static String data_hora;
    static String motivo_C;

    public static void main(String[] args) {
        String user = JOptionPane.showInputDialog(null, "Digite M para logar como Médico e P para Paciente");

        /*                                                                       DOCTOR PART                                                                                                   */
        if (user.equalsIgnoreCase("M")) {

            String menuMedico = "1-Cadastrar Médico\n2-Atualizar informações\n3-Visualizar informações\n4-Deletar informações\n5-Prescrições\n6-Visualizar Consultas\n0-Sair";
            String menuPres = "1-Nova Prescrição\n2-Atualizar prescrição\n3-Visualizar prescrição\n4-Deletar prescrição\n0-Sair";
            int option;

            do {
                option = Integer.parseInt(JOptionPane.showInputDialog(menuMedico));

                switch (option) {

                    case 1:
                        /*REGISTER DOCTOR*/
                        nome = JOptionPane.showInputDialog("Inserir nome");
                        email = JOptionPane.showInputDialog("Inserir email");
                        senha = JOptionPane.showInputDialog("Inserir senha");
                        cpf = JOptionPane.showInputDialog("Inserir cpf");
                        telefone = JOptionPane.showInputDialog("Inserir telefone");
                        especialidade = JOptionPane.showInputDialog("Inserir especiaidade");

                        medico.setNome(nome);
                        medico.setEmail(email);
                        medico.setSenha(senha);
                        medico.setCpf(cpf);
                        medico.setTelefone(telefone);
                        medico.setEspecialidade(especialidade);

                        medico.registerMedico();

                        break;

                    case 2:
                        /*UPDATE DOCTOR*/
                        nome = JOptionPane.showInputDialog("Inserir nome atualizado");
                        email = JOptionPane.showInputDialog("Inserir email atualizado");
                        senha = JOptionPane.showInputDialog("Inserir senha atualizada");
                        cpf = JOptionPane.showInputDialog("Inserir cpf atualizado");
                        telefone = JOptionPane.showInputDialog("Inserir telefone atualizado");
                        especialidade = JOptionPane.showInputDialog(null, "Inserir especiaidade atualizada");
                        medico_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id do médico que deseja atualizar"));

                        medico.setNome(nome);
                        medico.setEmail(email);
                        medico.setSenha(senha);
                        medico.setCpf(cpf);
                        medico.setTelefone(telefone);
                        medico.setEspecialidade(especialidade);
                        medico.setMedico_id(medico_id);

                        medico.updateMedico();
                        break;

                    case 3:
                        /* VIEW DOCTOR*/
                        medico_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id do médico que deseja visualizar"));

                        medico.setMedico_id(medico_id);

                        medico.viewMedico();
                        break;

                    case 4:
                        /*DELETE DOCTOR*/
                        medico_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id do médico que deseja deletar"));

                        medico.setMedico_id(medico_id);

                        medico.deleteMedico();
                        break;
                    case 5:
                        /*                        PRESCRIPTION PART                                                                                                                      */
                        do {
                            option = Integer.parseInt(JOptionPane.showInputDialog(menuPres));

                            switch (option) {
                                case 1:
                                    /*REGISTER PRESCRIPTION*/

                                    descricao = JOptionPane.showInputDialog(null, "Inserir a descrição da prescrição");
                                    medico_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id do médico responsável"));
                                    paciente_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id do paciente"));
                                    consulta_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id da consulta"));

                                    medico.setDescricao(descricao);
                                    medico.setMedico_id(medico_id);
                                    medico.setPaciente_id(paciente_id);
                                    medico.setConsulta_id(consulta_id);

                                    medico.newPrescricao();
                                    break;

                                case 2:
                                    /*UPDATE PRESCRIPTION*/

                                    descricao = JOptionPane.showInputDialog(null, "Inserir a descrição da prescrição atualizada");
                                    medico_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id do médico responsável atualizado"));
                                    paciente_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id do paciente atualizado"));
                                    consulta_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id da consulta atualizado"));
                                    prescricao_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id da prescrição que quer atualizar"));

                                    medico.setDescricao(descricao);
                                    medico.setMedico_id(medico_id);
                                    medico.setPaciente_id(paciente_id);
                                    medico.setConsulta_id(consulta_id);
                                    medico.setPrescricao_id(prescricao_id);

                                    medico.updatePrescricao();

                                    break;

                                case 3:
                                    /* VIEW PRESCRIPTION*/

                                    prescricao_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id da prescrição que quer visualizar"));

                                    medico.setPrescricao_id(prescricao_id);

                                    medico.viewPrescricao();
                                    break;

                                case 4:
                                    /* DELETE PRESCRIPTION*/

                                    prescricao_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id da prescrição que quer deletar"));

                                    medico.setPrescricao_id(prescricao_id);

                                    medico.deletePrescricao();

                                    break;

                                case 0:
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Invaid Option");
                            }
                        } while (option != 0);
                        break;

                    case 6:
                        /*VIEW APPOINTMENT*/
                        consulta_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id da consulta que quer visualizar"));

                        medico.setConsulta_id(consulta_id);

                        paciente.viewConsulta();
                        break;

                    case 0:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invaid Option");
                }
            } while (option != 0);

            /*                                                              PACIENT PART                                                                                                           */
        } else if (user.equalsIgnoreCase("P")) {

            String menuPaciente = "1-Cadastrar Paciente\n2-Atualizar informações\n3-Visualizar informações\n4-Deletar informações\n5-Consultas\n6-Visualizar Prescrições\n0-Sair";
            String menuConsulta = "1-Nova consulta\n2-Atualizar consulta \n3-Visualizar consulta\n4-Deletar consulta\n0-Sair";
            int option;

            do {

                option = Integer.parseInt(JOptionPane.showInputDialog(menuPaciente));

                switch (option) {

                    case 1:
                        /*REGISTER PATIENT*/
                        nome = JOptionPane.showInputDialog("Inserir nome");
                        email = JOptionPane.showInputDialog("Inserir email");
                        senha = JOptionPane.showInputDialog("Inserir senha");
                        cpf = JOptionPane.showInputDialog("Inserir cpf");
                        telefone = JOptionPane.showInputDialog("Inserir telefone");

                        paciente.setNome(nome);
                        paciente.setEmail(email);
                        paciente.setSenha(senha);
                        paciente.setCpf(cpf);
                        paciente.setTelefone(telefone);

                        paciente.registerPaciente();

                        break;

                    case 2:
                        /*UPDATE PATIENT*/
                        nome = JOptionPane.showInputDialog("Inserir nome atualizado");
                        email = JOptionPane.showInputDialog("Inserir email atualizado");
                        senha = JOptionPane.showInputDialog("Inserir senha atualizada");
                        cpf = JOptionPane.showInputDialog("Inserir cpf atualizado");
                        telefone = JOptionPane.showInputDialog("Inserir telefone atualizado");
                        paciente_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id do paciente que deseja atualizar"));

                        paciente.setNome(nome);
                        paciente.setEmail(email);
                        paciente.setSenha(senha);
                        paciente.setCpf(cpf);
                        paciente.setTelefone(telefone);
                        paciente.setPaciente_id(paciente_id);

                        paciente.updatePaciente();
                        break;

                    case 3:
                        /*VIEW PATIENT*/
                        paciente_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id do paciente que deseja visualizar"));

                        paciente.setPaciente_id(paciente_id);

                        paciente.viewPaciente();
                        break;

                    case 4:
                        /*DELETE PATIENT*/
                        paciente_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id do paciente que deseja deletar"));

                        paciente.setPaciente_id(paciente_id);

                        paciente.deletePaciente();
                        break;

                    case 5:
                        /*                     APPOINTMENT PART                                                                                                                                                                            */
                        do {

                            option = Integer.parseInt(JOptionPane.showInputDialog(menuConsulta));

                            switch (option) {
                                case 1:
                                    /*REGISTER APPOINTMENT*/

                                    data_hora = JOptionPane.showInputDialog(null, "Inserir a data e hora da consulta");
                                    motivo_C = JOptionPane.showInputDialog(null, "Inserir o motivo da consulta");
                                    medico_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id do médico responsável"));
                                    paciente_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id do paciente"));

                                    paciente.setData_hora(data_hora);
                                    paciente.setMotivo_C(motivo_C);
                                    medico.setMedico_id(medico_id);
                                    medico.setPaciente_id(paciente_id);

                                    paciente.newConsulta();

                                    break;

                                case 2:
                                    /*UPDATE APPOINTMENT*/
                                    data_hora = JOptionPane.showInputDialog(null, "Inserir a data e hora atualizada da consulta");
                                    motivo_C = JOptionPane.showInputDialog(null, "Inserir o motivo atualizado da consulta");
                                    medico_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id atualizado do médico responsável"));
                                    paciente_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id atualizado do paciente"));
                                    consulta_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id da consulta que quer atualizar"));

                                    paciente.setData_hora(data_hora);
                                    paciente.setMotivo_C(motivo_C);
                                    medico.setMedico_id(medico_id);
                                    medico.setPaciente_id(paciente_id);

                                    medico.setConsulta_id(consulta_id);

                                    paciente.updateConsulta();
                                    break;

                                case 3:
                                    /*VIEW APPOINTMENT*/

                                    consulta_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id da consulta que quer visualizar"));

                                    medico.setConsulta_id(consulta_id);

                                    paciente.viewConsulta();
                                    break;

                                case 4:
                                    /*DELETE APPOINTMENT*/
                                    consulta_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id da consulta que quer deletar"));

                                    medico.setConsulta_id(consulta_id);

                                    paciente.deleteConsulta();
                                    break;

                                case 0:
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Invaid Option");
                            }
                        } while (option != 0);

                        break;

                    case 6:
                        /*VIEW PRESCRIPTION*/
                        prescricao_id = Integer.parseInt(JOptionPane.showInputDialog("Inserir o id da prescrição que quer atualizar"));

                        medico.setPrescricao_id(prescricao_id);

                        medico.viewPrescricao();
                        break;

                    case 0:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invaid Option");
                }
            } while (option != 0);

        } else {
            JOptionPane.showMessageDialog(null, "Opção:" + user + "é inválida, tente novamente");
        }

    }
}
