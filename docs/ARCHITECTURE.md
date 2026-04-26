# FarmToPlay Architecture Plan

## Vision

Build the project as a mobile game platform, not only as one screen with logic inside it.
The initial skeleton is intentionally small, but the architecture should support:

- multiple game modes
- live events
- progression systems
- monetization and economy
- analytics
- backend integration
- parallel work across a team

## Recommended architecture

Use a layered feature-oriented approach.

### 1. Product layers

- `app`
  Entry point, DI wiring, app navigation, app-level configuration.
- `core`
  Shared UI, theme, common utilities, result wrappers, analytics contracts, data models used across features.
- `feature:*`
  User-facing flows such as main menu, settings, profile, shop, live events.
- `game:*`
  Pure gameplay systems and mode-specific logic.
- `data:*`
  Repositories, local persistence, remote APIs, save state, economy data.

### 2. Runtime direction

- UI layer only talks to ViewModel or Presenter.
- ViewModel coordinates use cases.
- Use cases depend on repository interfaces.
- Repository implementations live in data modules.
- Gameplay rules should stay framework-light and testable outside Android UI.

## Suggested module map for team scale

Start small with one `app` module, then split when feature pressure grows.

Recommended target structure:

- `:app`
- `:core:designsystem`
- `:core:ui`
- `:core:common`
- `:core:analytics`
- `:feature:menu`
- `:feature:settings`
- `:feature:profile`
- `:feature:shop`
- `:feature:events`
- `:game:engine`
- `:game:harvestsprint`
- `:game:farmbuilder`
- `:data:player`
- `:data:economy`
- `:data:events`
- `:data:save`

## Team ownership proposal

This split helps a team avoid stepping on each other.

- Gameplay team
  Owns `game:*`, balancing systems, progression rules, combat or farming loops.
- Client UI team
  Owns `feature:*`, screen composition, UX flows, HUD, onboarding.
- Platform team
  Owns `core:*`, build logic, CI, shared components, logging, performance budgets.
- Backend or economy team
  Owns `data:*`, contracts, remote config, player inventory, live ops content.

## Folder conventions inside a feature

For each feature or game mode, keep the same internal layout:

- `ui/`
- `viewmodel/`
- `domain/`
- `data/`
- `model/`

Example:

`feature/menu/ui/MainMenuScreen.kt`

`feature/menu/viewmodel/MainMenuViewModel.kt`

## Coding rules for team velocity

- Keep navigation declarations in one predictable place.
- Put strings and balancing values behind config objects as soon as they stop being temporary.
- Avoid direct repository calls from composables.
- Keep gameplay math in pure Kotlin classes where possible.
- Treat ViewModels as orchestration, not as a dump for all logic.
- Introduce interface contracts before adding remote services.

## Delivery roadmap

### Milestone 1: Prototype

- Menu
- One playable loop
- Local score/progression
- Fast iteration

### Milestone 2: Vertical slice

- Save/load
- One progression loop
- Audio and juice
- Tutorial
- Analytics events

### Milestone 3: Production baseline

- Multiple game modes
- Remote config
- Live event content
- Crash monitoring
- CI pipeline
- Automated tests

## Immediate next tasks for the team

1. Replace placeholder gameplay with a documented core loop.
2. Add dependency injection, for example Hilt or Koin.
3. Split the current `app` code into feature and core Gradle modules.
4. Add unit tests for gameplay rules before the logic becomes complex.
5. Define a save-game model and repository contracts.
