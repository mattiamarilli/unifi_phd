COMPOSE_PROJECT_NAME=unifi_phd
COMPOSE=docker-compose --project-name=$(COMPOSE_PROJECT_NAME) -f docker/docker-compose.yml

.PHONY: upd
upd:
	$(COMPOSE) up -d

.PHONY: up
up:
	$(COMPOSE) up

.PHONY: down
down:
	$(COMPOSE) down

.PHONY: db
db:
	docker exec -it unifi_phd-mdb sh -c 'mysql -uroot -ptest < /sql/schema.sql'

.PHONY: data
data:
	docker exec -it unifi_phd-mdb sh -c 'mysql -uroot -ptest < /sql/data.sql'