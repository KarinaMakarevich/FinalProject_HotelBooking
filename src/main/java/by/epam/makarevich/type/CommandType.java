package by.epam.makarevich.type;

import by.epam.makarevich.command.AbstractCommand;
import by.epam.makarevich.command.admin.*;
import by.epam.makarevich.command.client.*;
import by.epam.makarevich.command.common.ChangeLocaleCommand;
import by.epam.makarevich.command.common.OpenMainPageCommand;
import by.epam.makarevich.command.room.FindRoomsCommand;
import by.epam.makarevich.command.user.*;
import by.epam.makarevich.exception.ReceiverException;
import by.epam.makarevich.receiver.AdminReceiver;
import by.epam.makarevich.receiver.impl.*;
import by.epam.makarevich.request_content.RequestContent;

public enum CommandType {
    SIGN_UP(new SignUpCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent content) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).signUp(content);
        }
    },
    SIGN_IN(new SignInCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent content) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).signIn(content);
        }
    },
    OPEN_MAIN_PAGE(new OpenMainPageCommand(new CommonReceiverImpl())) {
        public void doReceiver(RequestContent content) throws ReceiverException {
            ((CommonReceiverImpl) getCommand().getReceiver()).openMainPage(content);
        }
    },
    CHANGE_LOCALE(new ChangeLocaleCommand(new CommonReceiverImpl())) {
        public void doReceiver(RequestContent content) throws ReceiverException {
            ((CommonReceiverImpl) getCommand().getReceiver()).changeLocale(content);
        }
    },
    FIND_ROOMS(new FindRoomsCommand(new RoomReceiverImpl())) {
        public void doReceiver(RequestContent content) throws ReceiverException {
            ((RoomReceiverImpl) getCommand().getReceiver()).findRooms(content);
        }
    },
    LOG_OUT(new LogOutCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent content) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).logOut(content);
        }
    },
    OPEN_CLIENT_PROFILE(new OpenClientProfileCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent content) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).openProfile(content);
        }
    },
    OPEN_ADMIN_PROFILE(new OpenAdminProfileCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent content) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).openProfile(content);
        }
    },
    CONFIRM_MAIL(new ConfirmMailCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent content) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).confirmMail(content);
        }
    },
    OPEN_CLIENT_APPS(new OpenClientAppsCommand(new ClientReceiverImpl())) {
        public void doReceiver(RequestContent content) throws ReceiverException {
            ((ClientReceiverImpl) getCommand().getReceiver()).openClientApplications(content);
        }
    },
    BOOK_ROOM(new BookRoomCommand(new ClientReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((ClientReceiverImpl) getCommand().getReceiver()).bookRoom(requestContent);
        }
    },
    CANCEL_ROOM(new CancelRoomCommand(new ClientReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((ClientReceiverImpl) getCommand().getReceiver()).cancelRoom(requestContent);
        }
    },
    OPEN_INCOMING_APPS(new OpenIncomingAppsCommand(new AdminReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((AdminReceiverImpl) getCommand().getReceiver()).openIncomingApps(requestContent);
        }
    },
    APPROVE_ORDER(new ApproveOrderCommand(new AdminReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((AdminReceiverImpl) getCommand().getReceiver()).approveOrder(requestContent);
        }
    },
    REVOKE_ORDER(new RevokeOrderCommand(new AdminReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((AdminReceiverImpl) getCommand().getReceiver()).revokeOrder(requestContent);
        }
    },
    ADD_ROOM(new AddRoomCommand(new AdminReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((AdminReceiverImpl) getCommand().getReceiver()).addRoom(requestContent);
        }
    },
    OPEN_ALL_APPS(new OpenAllAppsCommand(new AdminReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((AdminReceiverImpl) getCommand().getReceiver()).openAllApps(requestContent);
        }
    },
    OPEN_ALL_USERS(new OpenAllUsersCommand(new AdminReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((AdminReceiverImpl) getCommand().getReceiver()).openAllUsers(requestContent);
        }
    },
    BLOCK_USER(new BlockUserCommand(new AdminReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((AdminReceiver) getCommand().getReceiver()).blockUser(requestContent);
        }
    },
    UNBLOCK_USER(new UnblockUserCommand(new AdminReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((AdminReceiverImpl) getCommand().getReceiver()).unblockUser(requestContent);
        }
    },
    CONFIRM_AUTHORISATION(new ConfirmAuthorisationCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).sendEmailToAuthorize(requestContent);
        }
    },
    OPEN_LOGIN_SETTING(new OpenLoginSettingCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).openLoginSetting(requestContent);
        }
    },
    CHANGE_LOGIN(new ChangeLoginCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).changeLogin(requestContent);
        }
    },
    OPEN_PASSWORD_SETTING(new OpenPasswordSettingCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).openPasswordSetting(requestContent);
        }
    },
    CHANGE_PASSWORD(new ChangePasswordCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).changePassword(requestContent);
        }
    },
    OPEN_CLIENT_PENDING_APPS(new OpenClientPendingAppsCommand(new ClientReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((ClientReceiverImpl) getCommand().getReceiver()).openClientPendingApplications(requestContent);
        }
    },
    ADD_ROOM_FORM(new AddRoomFormCommand(new AdminReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((AdminReceiverImpl) getCommand().getReceiver()).addRoomForm(requestContent);
        }
    },
    OPEN_BALANCE_FORM(new OpenBalanceFormCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).openBalanceForm(requestContent);
        }
    },
    TOP_UP_BALANCE(new TopUpBalanceCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).topUpBalance(requestContent);
        }
    },
    RESET_PASSWORD(new ResetPasswordCommand(new UserReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((UserReceiverImpl) getCommand().getReceiver()).resetPassword(requestContent);
        }
    },
    OPEN_ADD_USER_FORM(new OpenAddUserFormCommand(new AdminReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((AdminReceiverImpl) getCommand().getReceiver()).openAddUserForm(requestContent);
        }
    },
    ADD_USER(new AddUserCommand(new AdminReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((AdminReceiverImpl) getCommand().getReceiver()).addUser(requestContent);
        }
    },
    OPEN_DELETE_ROOM_FORM(new OpenDeleteRoomFormCommand(new AdminReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((AdminReceiverImpl) getCommand().getReceiver()).openDeleteRoomForm(requestContent);
        }
    },
    DELETE_ROOM(new DeleteRoomCommand(new AdminReceiverImpl())) {
        public void doReceiver(RequestContent requestContent) throws ReceiverException {
            ((AdminReceiverImpl) getCommand().getReceiver()).deleteRoom(requestContent);
        }
    };
    private AbstractCommand command;

    CommandType(AbstractCommand command) {
        this.command = command;

    }

    public AbstractCommand getCommand() {
        return command;
    }

    public abstract void doReceiver(RequestContent content) throws ReceiverException;
}
