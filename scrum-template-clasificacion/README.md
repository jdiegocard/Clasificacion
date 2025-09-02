# Scrum Template for `Clasificacion`

Lightweight Scrum scaffolding to manage sprints, stories, bugs, PRs, and a GitHub Project board.

## Quick start
1. Create milestones as **Sprints** (example):
   - *Sprint 1*: 2025-09-01 → 2025-09-15 — Goal: baseline classification module
   - *Sprint 2*: 2025-09-16 → 2025-09-30 — Goal: improve accuracy & add tests
2. Create a **Project** (Projects → New project) with columns: *Backlog, To do, In progress, Review, Done*.
3. Import labels:
   ```bash
   gh label import labels.json
   ```
4. Use Issue templates for **User Story** and **Bug**. Link PRs with `Fixes #<id>`.
5. (Optional) Enable the workflow `.github/workflows/add-to-project.yml` and set repo secrets.

## What's inside
- `.github/ISSUE_TEMPLATE/` — **User Story** & **Bug** (Issue Forms).
- `.github/PULL_REQUEST_TEMPLATE.md` — PR checklist (DoD-aligned).
- `/docs/DEFINITION_OF_READY.md` & `/docs/DEFINITION_OF_DONE.md`.
- `/docs/sprint-ceremonies.md` — quick facilitation guide.
- `labels.json` — recommended labels.
- `.github/workflows/add-to-project.yml` — auto-add new issues to your Project.

## Examples
Create an Epic (parent issue) and link child issues (subtasks). Use checklists within issues for finer subtasks.

Happy shipping! 🚀
