#!/bin/bash

echo "$LOCAL_IP integration.operando.dmz.lab.esilab.org" >> /etc/hosts
echo "$LOCAL_IP integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP ldb.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP ldb.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP pdb.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP pdb.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP rm.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP rm.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP aapi.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP aapi.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP dan.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP dan.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP gk.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP gk.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP rpm.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP rpm.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP rpm.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP rpm.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP openldap.as.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP openldap.as.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP cas.as.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP cas.as.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP mysql.integration.operando.dmz.lab.esilab.org" >> /etc/hosts
echo "$LOCAL_IP mysql.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP mysql.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP mongo.integration.operando.dmz.lab.esilab.org" >> /etc/hosts
echo "$LOCAL_IP mongo.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP mongo.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP phpldapadmin.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP phpldapadmin.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP phpmyadmin.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP phpmyadmin.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP ae.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP ae.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP ldb.search.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP ldb.search.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP pfb.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP pfb.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP bda.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP bda.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP ose.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP ose.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP pc.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP pc.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP pq.pc.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP pq.pc.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP sos.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP sos.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP oapi.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP oapi.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP rapi.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP rapi.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP birt.rg.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP birt.rg.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP rg.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP rg.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP console.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP console.integration.operando.esilab.org" >> /etc/hosts
echo "$LOCAL_IP yellowpages.integration.operando.lan.esilab.org" >> /etc/hosts
echo "$LOCAL_IP yellowpages.integration.operando.esilab.org" >> /etc/hosts

dnsmasq -k
