/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Evelyn
 */
public class Veiculo {
       private String placa;
        private TipoVeiculo tipo;
        private Cliente cliente;

        public String getPlaca() {
            return placa;
        }

        public TipoVeiculo getTipo() {
            return tipo;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        public void setTipo(TipoVeiculo tipo) {
            this.tipo = tipo;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        @Override
        public String toString() {
            return getPlaca();
        }
    }