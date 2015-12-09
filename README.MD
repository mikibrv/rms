User: id, email (primaryEmail), alternativeEmailList, name, photo

SocialUser: id, cookie, cookieExpiration, otherParameters , user_fk, social_fk

SocialNetwork: id, name, connectionParams

UserContacts: id, socialUser_fk

__________________________________________________________-


Users: {
    id,
    email (primaryEmail),
    userContactId,(null if primary user)
    alternativeEmailList[],
    SocialNetworkConnection[]{
        name,
        cookies,
        email,
        otherParameters
    },
    UserProfile: {
        photo,
        name,
        tags,
        bio,
        occupation,
        SocialNetwork[]{
            name,
            url,
            photo,
            otherParameters
        }
    UserRelationship{
                UserCategory,
                Status
        }
    },
    UserCategory{
        name,
        Categories[]
    }

}

