```toml
name = 'ResolveTicket'
method = 'PUT'
url = 'http://localhost:8080/api/ticket/resolve/1'
sortWeight = 2000000
id = 'f322f70b-773e-4b41-a029-5aff5d5bb116'

[auth.bearer]
token = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJraWNrIn0.XFiUj02kpJiHPl8n-burmIbjgmytkcap_1YAFFxHqW5MEbdKn0wq1XBjuLqsKDZQ8KzogLpZD2wFcm1hppoClQ'

[body]
type = 'JSON'
raw = '''
{
  "id": 1,
  "titre": "CICD",
  "description": "Improve CICD Workflow",
  "priorite": {
    "id": 1,
    "nom": "IMMEDIAT"
  },
  "categories": [
    {
      "id": 1,
      "nom": "BUG"
    },
    {
      "id": 2,
      "nom": "FEATURE"
    }
  ],
  "soumissionneur": {
    "id": 1,
    "pseudo": "kick"
  }
}
'''
```
