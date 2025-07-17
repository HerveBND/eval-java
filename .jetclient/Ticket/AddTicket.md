```toml
name = 'AddTicket'
method = 'POST'
url = 'http://localhost:8080/api/tickets '
sortWeight = 1000000
id = 'fd87f0f4-4263-4d45-ac13-c9249e47bf85'

[body]
type = 'JSON'
raw = '''
{
  "titre": "Optimisation des Requêtes API",
  "description": "Implémenter la mise en cache des requêtes API fréquentes pour améliorer les performances de l'application JetClient. Cela devrait inclure :\n- Mise en place d'un système de cache local\n- Gestion intelligente de l'invalidation du cache\n- Indicateurs de performance pour mesurer l'amélioration",
  "resolu": false,
  "categorie": {
    "id": 3,
    "nom": "IMPROVEMENT"
  },
  "priorite": {
    "id": 2,
    "nom": "URGENT"
  },
  "resolveur": null,
  "soumissionneur": {
    "id": 1,
    "pseudo": "kick"
  }
}
'''
```
