### Create a private key
openssl genrsa -out user.key 2048

### Create a CSR ( Certification SIgning Request )
openssl req -new -key user.key \
  -out user.csr \
  -subj "/CN=user"
  
### Create a CSR with multiple Groups
openssl req -new -key user.key \
  -out user.csr \
  -subj "/CN=user/O=$group1/O=$group2/O=$group3"
  
  
### sign in the CRS with the kubernetes CA :
openssl x509 -req -in user.csr \
  -CA /etc/kubernetes/pki/ca.crt \
  -CAkey /etc/kubernetes/pki/ca.key \
  -CAcreateserial \
  -out user.crt -days 500
