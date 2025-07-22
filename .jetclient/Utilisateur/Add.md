```toml
name = 'Add'
method = 'POST'
url = 'http://localhost:8080/api/utilisateur'
sortWeight = 1000000
id = '6144a281-9ba8-4d8e-b80c-092930b1f665'

[auth]
type = 'NO_AUTH'

[body]
type = 'JSON'
raw = '''
{
  "pseudo": "jean.dupont",
  "password": "motDePasse123",
  "admin": 0
}
'''
```
