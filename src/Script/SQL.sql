create database dbclinicas;
use dbclinicas;



 <datasource jndi-name="java:jboss/datasources/CLINICADS" pool-name="CLINICADS" enabled="true" use-java-context="true">
                    <connection-url>jdbc:mysql://localhost:3306/dbClinicas</connection-url>
                    <driver>mysql</driver>
                    <pool>
                        <min-pool-size>5</min-pool-size>
                        <max-pool-size>30</max-pool-size>
                        <prefill>true</prefill>
                    </pool>
                    <security>
                        <user-name>root</user-name>
                    </security>
                </datasource>