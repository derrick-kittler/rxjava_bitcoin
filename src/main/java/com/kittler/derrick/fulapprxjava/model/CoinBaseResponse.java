package com.kittler.derrick.fulapprxjava.model;

public class CoinBaseResponse {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    /**
     * Inner class for the data that will be held
     * base, currency and amount
     */
    public class Data {
        private String base, currency, amount;


        public String getBase() {
            return base;
        }

        public void setBase(String base) {
            this.base = base;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }
}

